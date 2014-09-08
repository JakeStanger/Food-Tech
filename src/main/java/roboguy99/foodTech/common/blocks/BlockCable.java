package roboguy99.foodTech.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.common.tile.TileWire;

public class BlockCable extends BlockContainer
{
	private TileWire tileEntityCable;

	public BlockCable(Material material)
	{
		super(material);
		float pixel = 1F/16F;
		this.setBlockBounds(12*pixel/2, 12*pixel/2, 12*pixel/2, 1-12*pixel/2, 1-12*pixel/2, 1-12*pixel/2);
		this.useNeighborBrightness = true;
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
		this.tileEntityCable = new TileWire();
		return this.tileEntityCable;
	}
	
	 
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		FoodTech.print("Block update detected at " + x + ", " + y + ", " + z);
		world.scheduleBlockUpdate(x, y, z, block, tickRate(world));
		tileEntityCable.getAllConnectedWires(x, y, z, world);
	}
	 
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		tileEntityCable.getAllConnectedWires(x, y, z, world);
	}
	 
	public void onBlockAdded(World world, int x, int y, int z)
	{
		tileEntityCable.getAllConnectedWires(x, y, z, world);
	}
	
	public void breakBlock(World world, int x, int y, int z, Block block, int thingNoOneKnowsWhatItDoes)
	{
		tileEntityCable.getAllConnectedWires(x, y, z, world);
	}
}
