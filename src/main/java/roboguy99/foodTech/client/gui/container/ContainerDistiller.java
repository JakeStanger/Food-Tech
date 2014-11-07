package roboguy99.foodTech.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import roboguy99.foodTech.common.tile.TileDistiller;

public class ContainerDistiller extends Container
{
	public TileDistiller distiller;
	
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
}
