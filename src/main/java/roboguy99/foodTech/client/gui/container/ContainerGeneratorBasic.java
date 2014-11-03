package roboguy99.foodTech.client.gui.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import roboguy99.foodTech.common.tile.prefab.generator.TileBasicGenerator;

/**
 * A basic generator has no slots, however still has a GUI which displays important information.
 * This class is used to make the inventory still usable and update any dynamic content on the GUI.
 * @author Jake
 *
 */
public class ContainerGeneratorBasic extends Container
{
	public TileBasicGenerator generator;
	private int lastPower;
	
	public ContainerGeneratorBasic(InventoryPlayer inventoryPlayer, TileBasicGenerator generator)
	{
		this.generator = generator;
		
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

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
	
	public void addCraftingToCrafters(ICrafting crafter)
	{
		super.addCraftingToCrafters(crafter);
		crafter.sendProgressBarUpdate(this, 0, this.generator.power);
	}
	
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++)
		{
			ICrafting crafter = (ICrafting)this.crafters.get(i);
			
			if(this.lastPower != this.generator.power)
			{
				crafter.sendProgressBarUpdate(this, 0, this.generator.power);
			}
			
			this.lastPower = this.generator.power;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int progressBar, int var2)
	{
		if(progressBar == 0) this.generator.power = var2;
	}
}
