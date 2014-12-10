package roboguy99.foodTech.common.tile;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import roboguy99.foodTech.common.tile.prefab.TileThreeSlotMachine;
import roboguy99.foodTech.util.recipe.OvenRecipeHandler;

public class TileOven extends TileThreeSlotMachine
{
	private static final int PROCESS_TIME = 200;
	public int processTimeRemaining = TileOven.PROCESS_TIME;
	public int timeSpentProcessing = 0;
	private int furnaceBurnTime = 0;
	public int currentItemBurnTime = 0;
	public int temperature;
	private static final int MAX_TEMP = 300;
	private int ticksUntilHeated = 0;
	
	public void updateEntity()
	{
		boolean shouldMarkDirty = false;
		ItemStack slotFuel = this.getStackInSlot(1);
		
		if(slotFuel != null && this.getBurnTime(slotFuel.getItem()) > 0 && !this.isBurning())
		{
			slotFuel.stackSize--;
			this.furnaceBurnTime = this.getBurnTime(slotFuel.getItem());
			this.currentItemBurnTime = this.furnaceBurnTime;
			shouldMarkDirty = true;
			
			if(slotFuel.stackSize == 0)
			{
				slotFuel = null;
				this.setInventorySlotContents(1, null);
				shouldMarkDirty = true;
			}
		}
		
		//Decrement the time before the item is processed, and increment the time spent processing it
		if(this.processTimeRemaining > 0 && this.canProcess()) 
		{
			this.processTimeRemaining--;
			this.timeSpentProcessing++;
		}
		//Check for inventory contents and process any items
		if(!worldObj.isRemote && this.canProcess() && this.processTimeRemaining == 0)
		{
			this.processItem();
			this.processTimeRemaining = TileOven.PROCESS_TIME;
			this.timeSpentProcessing = 0;
		}
		
		if(this.isBurning() && this.temperature < MAX_TEMP && this.ticksUntilHeated == 0)
		{
			this.temperature++;
			this.ticksUntilHeated = 1;
		}
		else if (this.isBurning()) this.ticksUntilHeated = 0;
		
		if(!this.isBurning() && this.temperature > 0) this.temperature--;
		
		if(shouldMarkDirty) this.markDirty();
	}
	
	@Override
	protected boolean canProcess()
	{
		if (this.slot[0] == null || this.temperature < 200) //TODO custom temperature for each recipe
        {
            return false;
        }
        else //TODO switch if and else around
        {
        	ItemStack itemstack = OvenRecipeHandler.processing().getProcessResult(this.slot[0]);
            if (itemstack == null) return false;
            if (this.slot[2] == null) return true;
            if (!this.slot[2].isItemEqual(itemstack)) return false;
            int result = slot[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.slot[2].getMaxStackSize();
        }
	}

	@Override
	protected void processItem()
	{
		this.processTimeRemaining = TileOven.PROCESS_TIME;
    	
    	if(this.canProcess())
	    {
    		ItemStack itemstack = OvenRecipeHandler.processing().getProcessResult(this.slot[0]);
	
	        if (this.slot[2] == null)
	        {
	            this.slot[2] = itemstack.copy();
	        }
	        else if (this.slot[2].getItem() == itemstack.getItem())
	        {
	            this.slot[2].stackSize += itemstack.stackSize;
	        }
	
	        this.slot[0].stackSize--;
	
	        if (this.slot[0].stackSize <= 0)
	        {
	            this.slot[0] = null;
	        }
	    }
	}
	
	private int getBurnTime(Item item)
	{
		if(item == Items.coal) return 1600;
		if(item == Item.getItemFromBlock(Blocks.coal_block)) return 16000;
		return 0;
	}
	
	private boolean isBurning()
	{
		return this.furnaceBurnTime > 0;
	}
}
