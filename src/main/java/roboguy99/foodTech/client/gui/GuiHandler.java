package roboguy99.foodTech.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import roboguy99.foodTech.client.gui.container.ContainerGrindstone;
import roboguy99.foodTech.common.tile.TileGrindstone;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public static final int guiIDWindTurbine = 0;
	public static final int guiIDGrindstone = 1;
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{	
		switch(ID)
		{
			case guiIDGrindstone:
				return new ContainerGrindstone(player.inventory, (TileGrindstone) world.getTileEntity(x, y, z));
				
		}
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID)
		{
			case guiIDGrindstone:
				return new GuiGrindstone(player.inventory, (TileGrindstone) world.getTileEntity(x, y, z));
		}
		return null;
	}
}
