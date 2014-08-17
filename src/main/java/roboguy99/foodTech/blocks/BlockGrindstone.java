package roboguy99.foodTech.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import roboguy99.foodTech.Main;
import roboguy99.foodTech.gui.GuiHandler;
import roboguy99.foodTech.tileEntities.TileEntityGrindstone;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class BlockGrindstone extends BlockContainer
{
	public BlockGrindstone(Material material)
	{
		super(material);
		
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
		return new TileEntityGrindstone();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		FMLNetworkHandler.openGui(player, Main.instance, GuiHandler.guiIDGrindstone, world, x, y, z);
		return true;
	}
}
