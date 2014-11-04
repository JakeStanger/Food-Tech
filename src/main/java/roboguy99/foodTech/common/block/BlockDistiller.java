package roboguy99.foodTech.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import roboguy99.foodTech.common.tile.TileDistiller;

/**
 * Block class for the distillation chamber
 * @author Roboguy99
 *
 */
public class BlockDistiller extends BlockContainer
{
	public BlockDistiller(Material material)
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
	
	public TileEntity createNewTileEntity(World world, int var1)
	{
		return new TileDistiller();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		//Open gui
		return true;
	}
}
