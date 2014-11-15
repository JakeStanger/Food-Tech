package roboguy99.foodTech.common.block.machine.advanced;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import roboguy99.foodTech.common.block.prefab.TileBlock;
import roboguy99.foodTech.common.tile.TileOven;

public class BlockOven extends TileBlock
{
	public BlockOven(Material material, String name)
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
	
	public TileEntity createNewTileEntity(World world, int i) 
	{
		return new TileOven();
	}
}
