package roboguy99.foodTech.common.block.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roboguy99.foodTech.common.block.prefab.BaseBlock;
import roboguy99.foodTech.common.item.Items;
import roboguy99.foodTech.common.item.tool.ItemToolGas;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Worldgen block which can be contained and used for gas machines
 */
public class BlockGas extends BaseBlock
{
	private static final int GAS_PER_BLOCK = 1000;
	
	public BlockGas(Material material, String name)
	{
		super(material, name);
		this.setBlockUnbreakable();
		this.setLightOpacity(1);
		this.setBlockTextureName("roboguy99:blockGas");
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) 
	{	
		if(player.inventory.getCurrentItem() != null)
	    {	
			if(player.inventory.getCurrentItem().getItem() == Items.itemToolGas )
	    	{
				ItemStack stack = player.inventory.getCurrentItem();
				ItemToolGas item = (ItemToolGas) stack.getItem();
				
				if(item.getDamage(stack) <= item.getMaxDamage() - GAS_PER_BLOCK)
				{
					world.setBlock(x, y, z, Blocks.air);
					item.setDamage(stack, item.getDamage(stack) + GAS_PER_BLOCK);
					return true;
				}
	    	}
	    }
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    protected boolean canSilkHarvest()
    {
        return false;
    }
    
    public boolean isOpaqueCube()
    {
    	return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered (IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
        return i1 == (Block) this ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
    
    /**
     * Remove the block collision box
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }
}
