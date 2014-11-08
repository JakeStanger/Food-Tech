package roboguy99.foodTech.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import roboguy99.foodTech.common.tile.prefab.Tile;

public class TileDistiller extends Tile implements IInventory
{
	protected ItemStack[] slot = new ItemStack[4];
	private String customName;
	private static final int MAX_WATER = 10000;
	private static final int PROCESS_TIME = 200;
	public int water = 0;
	public int distilledWater = 0;
	public int processTimeRemaining;
	public int timeSpentProcessing;
	
	@Override
	public void updateEntity()
	{
		
	}
	
	@Override
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
	
	public String getInventoryName() 
	{
		return this.hasCustomInventoryName() ? this.customName : "container.threeSlotMachine";
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
