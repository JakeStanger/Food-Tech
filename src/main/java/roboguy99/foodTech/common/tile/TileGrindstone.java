package roboguy99.foodTech.common.tile;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import roboguy99.foodTech.common.tile.prefab.TileThreeSlotMachine;
import roboguy99.foodTech.util.recipe.GrindstoneRecipes;

public class TileGrindstone extends TileThreeSlotMachine
{	
	private ItemStack[] slot = new ItemStack[3];
	
	private static final int MAX_STONE = 16;
	private static final int PROCESS_TIME = 200;
	public int stone = 0;
	private int processTimeRemaining;
	public int timeSpentProcessing;
	
	public void updateEntity()
	{	
		boolean shouldMarkDirty = false;
		ItemStack slotStone = getStackInSlot(1);
		
		//Check for stone in buffer and fill from itemstack in bottom slot
		if(slotStone != null && slotStone.getItem() == Item.getItemFromBlock(Blocks.cobblestone) && stone < MAX_STONE)
		{
			this.stone += MAX_STONE; //1 cobblestone = 1 full tank
			slotStone.stackSize--;
			shouldMarkDirty = true;
			
			if (slotStone.stackSize <= 0)
	        {
	            slotStone = null;
	            this.setInventorySlotContents(1, null);
	            shouldMarkDirty = true;
	        }
		}
		
		//Check for inventory contents and process any items
		if(!worldObj.isRemote && this.canProcess() && this.stone >= 1 && this.processTimeRemaining == 0)
		{
			this.processItem();
			this.processTimeRemaining = TileGrindstone.PROCESS_TIME;
			this.timeSpentProcessing = 0;
		}
		if(this.processTimeRemaining > 0 && this.canProcess()) 
		{
			this.processTimeRemaining--;
			this.timeSpentProcessing++;
		}
		
		if(shouldMarkDirty)
		{
			this.markDirty();
		}
	}
	
	public int getStoneScaled(int scaled)
	{
		return (int) (this.stone * scaled / TileGrindstone.MAX_STONE);
	}
	
	public int getProgressScaled(int scaled)
	{
		return (int) (this.timeSpentProcessing * scaled / TileGrindstone.PROCESS_TIME);
	}
	
	/**
     * Returns true if the grindstone can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    protected boolean canProcess()
    {
    	if (this.slot[0] == null || this.stone == 0)
        {
            return false;
        }
        else //TODO switch if and else around
        {
        	ItemStack itemstack = GrindstoneRecipes.processing().getProcessResult(this.slot[0]);
            if (itemstack == null) return false;
            if (this.slot[2] == null) return true;
            if (!this.slot[2].isItemEqual(itemstack)) return false;
            int result = slot[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.slot[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the grindstone source stack into the appropriate processed item in the furnace result stack
     */
    public void processItem()
    {	
    	this.processTimeRemaining = TileGrindstone.PROCESS_TIME;
    	
    	if(this.canProcess())
	    {
    		ItemStack itemstack = GrindstoneRecipes.processing().getProcessResult(this.slot[0]);
	
	        if (this.slot[2] == null)
	        {
	            this.slot[2] = itemstack.copy();
	        }
	        else if (this.slot[2].getItem() == itemstack.getItem())
	        {
	            this.slot[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
	        }
	
	        --this.slot[0].stackSize;
	        --this.stone;
	
	        if (this.slot[0].stackSize <= 0)
	        {
	            this.slot[0] = null;
	        }
	    }	
    }
}
