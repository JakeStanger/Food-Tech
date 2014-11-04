package roboguy99.foodTech.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import roboguy99.foodTech.util.recipe.GrindstoneRecipes;

public class TileGrindstone extends TileEntity implements ISidedInventory
{	
	private ItemStack[] slot = new ItemStack[3];
	
	private static final int MAX_STONE = 16;
	private static final int PROCESS_TIME = 200;
	public int stone = 0;
	private String customName;
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
	
	public ItemStack decrStackSize(int i, int j) 
	{
			if(this.slot[i] != null)
			{
				ItemStack itemStack;
				
				if(this.slot[i].stackSize <= j)
				{
					itemStack = this.slot[i];
					this.slot[i] = null;
					return itemStack;
				}
				else
				{
					itemStack = this.slot[i].splitStack(j);
					
					if(this.slot[i].stackSize == 0)
					{
						this.slot[i] = null;
						this.setInventorySlotContents(i, null);
					}
					
					return itemStack;
				}
			}
		
		return null;
	}
	
	public ItemStack getStackInSlot(int i) 
	{
		return this.slot[i];
	}
	
	public ItemStack getStackInSlotOnClosing(int i) 
	{
		if(this.slot[i] != null)
		{
			ItemStack itemStack = this.slot[i];
			this.slot[i] = null;
			return itemStack;
		}
		
		return null;
	}
	
	public boolean isItemValidForSlot(int slot, ItemStack itemStack)
	{
		return slot == 2 ? false : true;
	}
	
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) 
	{
		return true;
	}
	
	public void setInventorySlotContents(int i, ItemStack itemStack) 
	{
		this.slot[i] = itemStack;
		
		if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
		{
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}
	
	public boolean canExtractItem(int i, ItemStack var2, int j) 
	{
		return true;
	}
	
	public boolean canInsertItem(int slot, ItemStack itemStack, int side) 
	{
		return this.isItemValidForSlot(slot, itemStack);
	}
	
	public int[] getAccessibleSlotsFromSide(int i) 
	{
		return null;
	}
	
	/**
     * Returns true if the grindstone can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canProcess()
    {
        if (this.slot[0] == null || this.stone == 0)
        {
            return false;
        }
        else
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
    
    public String getInventoryName() 
	{
		return this.hasCustomInventoryName() ? this.customName : "container.grindstone";
	}
	
	public boolean hasCustomInventoryName() 
	{
		return this.customName != null && this.customName.length() > 0;
	}

	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	public int getSizeInventory() 
	{
		return this.slot.length;
	}
	
	public void openInventory() {}
	public void closeInventory() {}
}
