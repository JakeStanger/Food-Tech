package roboguy99.foodTech.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import roboguy99.foodTech.util.RecipeHandler;

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
		ItemStack slotOutput = getStackInSlot(2);
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
		return false;
	}
	
	public boolean canInsertItem(int i, ItemStack itemStack, int j) 
	{
		return false;
	}
	
	public int[] getAccessibleSlotsFromSide(int i) 
	{
		return null;
	}
	
	public void addRecipes()
	{
		//TODO add recipes
	}
}
