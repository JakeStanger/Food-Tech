package roboguy99.foodTech.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.client.gui.GuiHandler;
import roboguy99.foodTech.common.block.prefab.BaseBlock;
import roboguy99.foodTech.common.tile.TileGrindstone;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class BlockGrindstone extends BaseBlock
{
	public BlockGrindstone(Material material, String name)
	{
		super(material, name);
		
		float pixel = 1F/16F;
		this.setBlockBounds(0+pixel, 0, 0+pixel, 1-pixel, 1-(2*pixel), 1-pixel);
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
	
	public TileEntity createNewTileEntity(World world, int var2) 
	{
		return new TileGrindstone();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		FMLNetworkHandler.openGui(player, FoodTech.instance, GuiHandler.GUIID_GRINDSTONE, world, x, y, z);
		return true;
	}
}
