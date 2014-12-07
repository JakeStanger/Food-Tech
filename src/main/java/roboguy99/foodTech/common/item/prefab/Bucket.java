package roboguy99.foodTech.common.item.prefab;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.common.fluid.Fluids;
import cpw.mods.fml.common.registry.GameRegistry;


public class Bucket extends ItemBucket
{
	public Bucket(Block block, String name)
	{
		super(block);
		this.setUnlocalizedName(name);
		this.setCreativeTab(FoodTech.TAB_FOODTECH);
		GameRegistry.registerItem(this, name);
		FluidContainerRegistry.registerFluidContainer(Fluids.fluidDistilledWater, new ItemStack(this), new ItemStack(Items.bucket));
	}
	
}
