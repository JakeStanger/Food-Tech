package roboguy99.foodTech.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWindTurbine extends TileEntity implements ISidedInventory
{
	private ItemStack[] slot = new ItemStack[2];
	
	public static float rotation = 0F;
	
	public int maxPower = 10000;
	public float power = 0F;
	public float powerPerRotation = 1F;
	
	public void updateEntity()
	{
		if(this.getWorldObj().getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) > 6)
		{
			rotation++;
			
			powerPerRotation = 5;
			
			power+=powerPerRotation;
			
			if(power > maxPower) power = maxPower;
		}
	}
	
	/**
	 * Returns the power contained in the generator for the purpose of fitting onto the gui
	 * this.power * scaled / this.maxPower
	 * @param scaled The number to multiply the power by
	 * @return
	 */
	public int getPowerScaled(int scaled)
	{
		return (int) (this.power * scaled / this.maxPower);
	}

	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("Slots", 10);
		this.slot = new ItemStack[getSizeInventory()];
		
		for(int i = 0; i < list.tagCount(); i++)
		{
			NBTTagCompound item = list.getCompoundTagAt(i);
			byte b = item.getByte("Item");
			
			if (b >= 0 && b < this.slot.length) this.slot[b] = ItemStack.loadItemStackFromNBT(item);
		}
		
		this.power = nbt.getFloat("Power");
		
		if(nbt.hasKey("CustomName")) this.setInventoryName(nbt.getString("CustomName"));
	}
	
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setFloat("Power", power);
		
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < this.slot.length; i++)
		{
			if(this.slot[i] != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Item", (byte) i);
				this.slot[i].writeToNBT(item);
				list.appendTag(item);
			}
		}
		
		nbt.setTag("Slots", list);
		
		if(this.hasCustomInventoryName())
		{
			nbt.setString("CustomName", this.getInventoryName());
		}
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

	public void setInventoryName(String name)
	{
		
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
		
		return false;
	}

	public boolean isUseableByPlayer(EntityPlayer entityPlayer)
	{
		
		return false;
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

	public boolean canExtractItem(int i, ItemStack itemStack, int j) 
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
}
