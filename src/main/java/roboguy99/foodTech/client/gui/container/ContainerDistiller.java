package roboguy99.foodTech.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import roboguy99.foodTech.common.tile.TileDistiller;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerDistiller extends Container
{
	public TileDistiller distiller;
	private int lastWater = 0;
	private int lastDistilledWater = 0;
	private int lastProcessTime = 0;
	private int lastItemBurnTime = 0;
	
	public ContainerDistiller(InventoryPlayer inventoryPlayer, TileDistiller distiller)
	{
		this.distiller = distiller;
		
		this.addSlotToContainer(new Slot(distiller, 0, 8, 62));
		this.addSlotToContainer(new Slot(distiller, 1, 26, 62));
		this.addSlotToContainer(new Slot(distiller, 2, 134, 62));
		this.addSlotToContainer(new Slot(distiller, 3, 152, 62));
		
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
	
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
	
	public void addCraftingToCrafters(ICrafting crafter)
	{
		super.addCraftingToCrafters(crafter);
		crafter.sendProgressBarUpdate(this, 0, this.distiller.water);
		crafter.sendProgressBarUpdate(this, 1, this.distiller.distilledWater);
		crafter.sendProgressBarUpdate(this, 2, this.distiller.timeSpentProcessing);
		crafter.sendProgressBarUpdate(this, 3, this.distiller.currentItemBurnTime);
	}
	
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++)
		{
			ICrafting crafter = (ICrafting)this.crafters.get(i);
			
			if(this.lastWater != this.distiller.water) crafter.sendProgressBarUpdate(this, 0, this.distiller.water);
			if(this.lastDistilledWater != this.distiller.distilledWater) crafter.sendProgressBarUpdate(this, 1, this.distiller.distilledWater);
			if(this.lastProcessTime != this.distiller.timeSpentProcessing) crafter.sendProgressBarUpdate(this, 2, this.distiller.processTimeRemaining);
			if(this.lastItemBurnTime != this.distiller.currentItemBurnTime) crafter.sendProgressBarUpdate(this, 3, this.distiller.currentItemBurnTime);
			
			this.lastWater = this.distiller.water;
			this.lastDistilledWater = this.distiller.distilledWater;
			this.lastProcessTime = this.distiller.timeSpentProcessing;
			this.lastItemBurnTime = this.distiller.currentItemBurnTime;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int progressBar, int var2)
	{
		if(progressBar == 0) this.distiller.water = var2;
		if(progressBar == 1) this.distiller.distilledWater = var2;
		if(progressBar == 2) this.distiller.timeSpentProcessing = var2;
		if(progressBar == 3) this.distiller.currentItemBurnTime = var2;
	}
	
	/**
	 * Called when the player shift-clicks an item TODO Finish this
	 */
	public ItemStack transferStackInSlot(EntityPlayer player, int index)
	{
		return null;
	}
}
