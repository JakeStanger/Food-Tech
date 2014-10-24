package roboguy99.foodTech.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.client.gui.GuiHandler;
import roboguy99.foodTech.common.tile.electricity.generator.TileWindTurbine;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class BlockWindTurbine extends BlockContainer //Class for the windTurbine block. The block is turned into a tileEntity when placed
{
	public BlockWindTurbine(Material material, int generated, int buffer, String type)
	{
		super(material);
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

	public TileEntity createNewTileEntity(World var1, int var2) //Replaces the block with its tileEntity counterpart
	{
		return new TileWindTurbine(Blocks.TURBINE_GENERATED, Blocks.TURBINE_BUFFERSIZE);
	}
	
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		if (world.getBlock(x, y+1, z) == Blocks.blockWindTurbine) world.setBlockToAir(x, y+1, z);
		if (world.getBlock(x, y-1, z) == Blocks.blockWindTurbine) world.setBlockToAir(x, y-1, z);
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		float pixel = 1F/16F;
		
		if(world.getBlockMetadata(x, y, z) < 7) this.setBlockBounds(pixel*4, 0, pixel*4, 1-pixel*4, 1, 1-pixel*4);
		else this.setBlockBounds(0, 0, 0, 1, 1, 1);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{	
		if(!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, FoodTech.instance, GuiHandler.guiIDGeneratorBasic, world, x, y, z);
			return true;
		}
		return false;
	}
}
