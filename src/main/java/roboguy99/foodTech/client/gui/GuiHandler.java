package roboguy99.foodTech.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import roboguy99.foodTech.client.gui.container.ContainerDistiller;
import roboguy99.foodTech.client.gui.container.ContainerGeneratorBasic;
import roboguy99.foodTech.client.gui.container.ContainerGrindstone;
import roboguy99.foodTech.common.tile.TileDistiller;
import roboguy99.foodTech.common.tile.TileGrindstone;
import roboguy99.foodTech.common.tile.prefab.generator.TileBasicGenerator;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public static final int GUIID_GENERATOR_BASIC = 0;
	public static final int GUIID_GRINDSTONE = 1;
	public static final int GUIID_DISTILLER = 2;
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{	
		switch(ID)
		{
			case GUIID_GENERATOR_BASIC:
				return new ContainerGeneratorBasic(player.inventory, (TileBasicGenerator) world.getTileEntity(x, y, z));
			case GUIID_GRINDSTONE:
				return new ContainerGrindstone(player.inventory, (TileGrindstone) world.getTileEntity(x, y, z));
			case GUIID_DISTILLER:
				return new ContainerDistiller(player.inventory, (TileDistiller) world.getTileEntity(x, y, z));
		}
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID)
		{
			case GUIID_GENERATOR_BASIC:
				return new GuiGeneratorBasic(player.inventory, (TileBasicGenerator) world.getTileEntity(x, y, z));
			case GUIID_GRINDSTONE:
				return new GuiGrindstone(player.inventory, (TileGrindstone) world.getTileEntity(x, y, z));
			case GUIID_DISTILLER:
				return new GuiDistiller(player.inventory, (TileDistiller) world.getTileEntity(x, y, z));
		}
		return null;
	}
}
