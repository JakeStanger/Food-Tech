package roboguy99.foodTech.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import roboguy99.foodTech.client.gui.container.ContainerGrindstone;
import roboguy99.foodTech.client.gui.container.ContainerWindTurbine;
import roboguy99.foodTech.common.tile.TileGrindstone;
import roboguy99.foodTech.common.tile.generators.TileWindTurbine;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public static final int guiIDWindTurbine = 0;
	public static final int guiIDGrindstone = 1;
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
				
		switch(ID)
		{
			case guiIDWindTurbine:
				while(tileEntity instanceof TileWindTurbine && world.getBlockMetadata(x, y, z) < 8)
				{
					y++;
				}
				
				return new ContainerWindTurbine(player.inventory, (TileWindTurbine) world.getTileEntity(x, y, z));
			
			case guiIDGrindstone:
				return new ContainerGrindstone(player.inventory, (TileGrindstone) world.getTileEntity(x, y, z));
				
		}
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		switch(ID)
		{
			case guiIDWindTurbine:
				while(tileEntity instanceof TileWindTurbine && world.getBlockMetadata(x, y, z) < 8)
				{
					System.out.println(y);
					y++;
				}
				
				return new GuiWindTurbine(player.inventory, (TileWindTurbine) world.getTileEntity(x, y, z));
			case guiIDGrindstone:
				return new GuiGrindstone(player.inventory, (TileGrindstone) world.getTileEntity(x, y, z));
		}
		return null;
	}
}
