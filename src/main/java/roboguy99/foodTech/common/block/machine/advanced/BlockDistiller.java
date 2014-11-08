package roboguy99.foodTech.common.block.machine.advanced;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.client.gui.GuiHandler;
import roboguy99.foodTech.common.block.prefab.BaseBlock;
import roboguy99.foodTech.common.tile.TileDistiller;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

/**
 * Block class for the distillation chamber
 * @author Roboguy99
 *
 */
public class BlockDistiller extends BaseBlock
{
	public BlockDistiller(Material material, String name)
	{
		super(material, name);
	}
	
	public int getRenderType()
	{
		return -1;
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public TileEntity createNewTileEntity(World world, int var1)
	{
		return new TileDistiller();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		FMLNetworkHandler.openGui(player, FoodTech.instance, GuiHandler.GUIID_DISTILLER, world, x, y, z);
		return true;
	}
}
