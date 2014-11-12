package roboguy99.foodTech.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
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
	private int furnaceBurnTime = 0;
	public int currentItemBurnTime = 0;
	private int temperature;
	private static final int MAX_TEMP = 300;
	
	@Override
	public void updateEntity()
	{
		boolean shouldMarkDirty = false;
		
		ItemStack slotBucketIn = this.getStackInSlot(0);
		ItemStack slotFuel = this.getStackInSlot(1);
		ItemStack slotSalt = this.getStackInSlot(2);
		ItemStack slotBucketOut = this.getStackInSlot(3);
		
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
		
		if(slotBucketIn != null && slotBucketIn.getItem() == Items.water_bucket && (this.water + 1000) <= MAX_WATER)
		{
			slotBucketIn = null;
			this.setInventorySlotContents(0, null);
			
			this.water += 1000;
			
			this.setInventorySlotContents(0, new ItemStack(Items.bucket));
			
			shouldMarkDirty = true;
		}
		
		if(this.temperature > 100 && this.isBurning() && this.water > 0 && this.distilledWater < MAX_WATER)
		{
			this.water--;
			this.distilledWater++;
			
			shouldMarkDirty = true;
			
			if(this.processTimeRemaining == 0)
			{
				if (slotSalt == null) this.setInventorySlotContents(3, new ItemStack(roboguy99.foodTech.common.item.Items.itemSalt));
				else slotSalt.stackSize++;
				
				this.processTimeRemaining = TileDistiller.PROCESS_TIME;
				this.timeSpentProcessing = 0;
				
				shouldMarkDirty = true;
			}
		}
		
		if(slotBucketOut != null && slotBucketOut.getItem() == Items.bucket && (this.distilledWater - 1000) >= 0)
		{
			slotBucketOut = null;
			this.setInventorySlotContents(3, null);
			
			this.distilledWater -= 1000;
			
			this.setInventorySlotContents(3, new ItemStack(roboguy99.foodTech.common.item.Items.itemBucketDistilledWater));
			
			shouldMarkDirty = true;
		}
		
		if(this.isBurning() && this.temperature < MAX_TEMP) this.temperature++;
		if(!this.isBurning() && this.temperature > 0) this.temperature--;
		
		this.processTimeRemaining--;
		this.timeSpentProcessing++;
		
		if(this.furnaceBurnTime > 0) this.furnaceBurnTime--;
		if(shouldMarkDirty) this.markDirty();
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
	
	public int getWaterScaled(int scaled)
	{
		return (int) this.water / scaled * TileDistiller.MAX_WATER;
	}
	
	public int getDistilledWaterScaled(int scaled)
	{
		return (int) this.distilledWater / scaled * TileDistiller.MAX_WATER;
	}
	
	public int getProgressScaled(int scaled)
	{
		return (int) this.timeSpentProcessing / scaled * TileDistiller.PROCESS_TIME;
	}
	
	public int getBurnTimeRemainingScaled(int scaled)
	{
		return (int) this.furnaceBurnTime / scaled * this.currentItemBurnTime;
	}
	
	public int getTemperature(int scaled)
	{
		return (int) this.temperature / scaled * TileDistiller.MAX_TEMP;
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
