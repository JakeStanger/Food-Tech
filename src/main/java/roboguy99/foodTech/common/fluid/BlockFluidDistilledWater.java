package roboguy99.foodTech.common.fluid;

import roboguy99.foodTech.FoodTech;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluidDistilledWater extends BlockFluidClassic
{
	public BlockFluidDistilledWater(Fluid fluid, Material material)
	{
		super(fluid, material);
		this.setCreativeTab(FoodTech.TAB_FOODTECH);
		GameRegistry.registerBlock(this, "blockFluidDistilledWater");
	}
	
	// Use Register Icon as usual to get the block's icon.
	// If you want you can reuse the water texture and change the color of it by doing as I have below:
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
	return Blocks.flowing_water.getIcon(side, meta);
	}

	@Override
	public int colorMultiplier(IBlockAccess iblockaccess, int x, int y, int z)
	{
	return 0xD2F3FA; // HEX colour code as indicated by the 0x in front. This is a greenish colour.
	}
}
