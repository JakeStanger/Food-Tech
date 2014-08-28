package roboguy99.foodTech.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import roboguy99.foodTech.common.tileEntities.TileEntityOven;

public class BlockOven extends BlockContainer
{
	public BlockOven(Material material)
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
	
	public TileEntity createNewTileEntity(World world, int i) 
	{
		return new TileEntityOven();
	}
}
