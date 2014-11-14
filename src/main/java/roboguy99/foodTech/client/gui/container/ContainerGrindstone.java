package roboguy99.foodTech.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import roboguy99.foodTech.client.gui.slot.SlotOutput;
import roboguy99.foodTech.common.tile.TileGrindstone;
import roboguy99.foodTech.util.recipe.GrindstoneRecipeHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerGrindstone extends Container
{
	public TileGrindstone grindstone;
	private int lastProcessTime;
	private int lastStoneContents;
	
	public ContainerGrindstone(InventoryPlayer inventoryPlayer, TileGrindstone grindstone)
	{
		this.grindstone = grindstone;
		
		this.addSlotToContainer(new Slot(grindstone, 0, 56, 17));
		this.addSlotToContainer(new Slot(grindstone, 1, 56, 53));
		this.addSlotToContainer(new SlotOutput(grindstone, 2, 116, 35));
		
		for(int i = 0; i < 3; i++) //Create the inventory slots
		{
			for(int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(inventoryPlayer, 9+j+i*9, 8+j*18, 84+18*i));
			}
		}
		
		for(int i = 0; i < 9; i++) //Create the hotbar slots
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8+18*i, 142));
		}
	}
	
	public void addCraftingToCrafters(ICrafting crafter)
	{
		super.addCraftingToCrafters(crafter);
		crafter.sendProgressBarUpdate(this, 0, this.grindstone.timeSpentProcessing);
		crafter.sendProgressBarUpdate(this, 1, this.grindstone.stone);
	}
	
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++)
		{
			ICrafting crafter = (ICrafting)this.crafters.get(i);
			
			if(this.lastProcessTime != this.grindstone.timeSpentProcessing)
			{
				crafter.sendProgressBarUpdate(this, 0, this.grindstone.timeSpentProcessing);
			}
			if(this.lastStoneContents != this.grindstone.stone)
			{
				crafter.sendProgressBarUpdate(this, 1, this.grindstone.stone);
			}
			
			this.lastProcessTime = this.grindstone.timeSpentProcessing;
			this.lastStoneContents = this.grindstone.stone;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int progressBar, int var2)
	{
		if(progressBar == 0) this.grindstone.timeSpentProcessing = var2;
		if(progressBar == 1) this.grindstone.stone = var2;
	}
	
	public boolean canInteractWith(EntityPlayer player) 
	{
		return this.grindstone.isUseableByPlayer(player);
	}
	
	/**
	 * Called when the player shift-clicks an item
	 */
	public ItemStack transferStackInSlot(EntityPlayer player, int index)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 1 && index != 0)
            {
                if (GrindstoneRecipeHandler.processing().getProcessResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (itemstack1.getItem() == Item.getItemFromBlock(Blocks.cobblestone))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }
		
		return itemstack;
	}
	
}
