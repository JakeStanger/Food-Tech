package roboguy99.foodTech.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;

public class TileGrindstone extends TileEntity implements ISidedInventory
{	
	private ItemStack[] slot = new ItemStack[3];
	
	//TODO: Remove stone system as it makes no sense
	public int maxStone = 16;
	public int stone = 0;
	
	public void updateEntity()
	{	
		ItemStack slotStone = getStackInSlot(1);
		
		if(slotStone != null && slotStone.getItem() == Item.getItemFromBlock(Blocks.cobblestone) && stone < maxStone)
		{
			stone++;
			slotStone.stackSize--;
		}
	}
	
	public int getStoneScaled(int scaled)
	{
		return (int) (this.stone * scaled / this.maxStone);
	}
	
	public void closeInventory() 
	{
		
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
					}
					
					return itemStack;
				}
			}
		
		return null;
	}
	
	public String getInventoryName() 
	{
		return null;
	}
	
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	public int getSizeInventory() 
	{
		return this.slot.length;
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
	
	public boolean hasCustomInventoryName() 
	{
		return false;
	}
	
	public boolean isItemValidForSlot(int i, ItemStack itemStack)
	{
		ItemStack slotOutput = this.getStackInSlot(2);
		if(itemStack == slotOutput) return false;
		return true;
		
	}
	
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) 
	{
		return true;
	}
	
	public void openInventory() 
	{
		
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
	
	public boolean canInsertItem(int i, ItemStack itemStack, int j) 
	{
		return this.isItemValidForSlot(i, itemStack);
	}
	
	public int[] getAccessibleSlotsFromSide(int i) 
	{
		return null;
	}
	
	public static void addRecipe()
	{
		//TODO add recipes
	}
	
	/**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.slot[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slot[0]);
            if (itemstack == null) return false;
            if (this.slot[2] == null) return true;
            if (!this.slot[2].isItemEqual(itemstack)) return false;
            int result = slot[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.slot[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slot[0]);

            if (this.slot[2] == null)
            {
                this.slot[2] = itemstack.copy();
            }
            else if (this.slot[2].getItem() == itemstack.getItem())
            {
                this.slot[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.slot[0].stackSize;

            if (this.slot[0].stackSize <= 0)
            {
                this.slot[0] = null;
            }
        }
    }
}
