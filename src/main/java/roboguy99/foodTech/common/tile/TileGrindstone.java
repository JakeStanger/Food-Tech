package roboguy99.foodTech.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import roboguy99.foodTech.GrindstoneRecipes;

public class TileGrindstone extends TileEntity implements ISidedInventory
{	
	private ItemStack[] slot = new ItemStack[3];
	
	private static final int MAX_STONE = 16;
	public int stone = 0;
	public String customName;
	
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
			
			if(shouldMarkDirty)
			{
				this.markDirty();
			}
		}
		
		//Check for inventory contents and process any items
		if(!worldObj.isRemote && this.canProcess() && this.stone >= 1)
		{
			this.processItem();
		}
	}
	
	public int getStoneScaled(int scaled)
	{
		return (int) (this.stone * scaled / TileGrindstone.MAX_STONE);
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
        if (this.canProcess())
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
            System.out.println(this.stone);

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
