package roboguy99.foodTech.util.recipe;

import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import roboguy99.foodTech.common.block.Blocks;
import roboguy99.foodTech.common.item.Items;
import roboguy99.foodTech.util.BucketHandler;

/**
 * TODO Think of a better name!
 * This class is where all recipes for custom machines are registered and all buckets for custom liquids go.
 * @author Jake
 *
 */
public class RecipesAndBuckets
{
	public RecipesAndBuckets()
	{
		this.addGrindstoneRecipes();
		this.addOvenRecipes();
		this.addBucket();
	}
	
	private void addGrindstoneRecipes()
	{
		GrindstoneRecipeHandler.INSTANCE.addItemRecipe(net.minecraft.init.Items.wheat, new ItemStack(roboguy99.foodTech.common.item.Items.itemFlour), 0.1F);
	}
	
	private void addOvenRecipes()
	{
		OvenRecipeHandler.INSTANCE.addItemRecipe(net.minecraft.init.Items.potato, new ItemStack(net.minecraft.init.Items.baked_potato), 0.1F);
		OvenRecipeHandler.INSTANCE.addItemRecipe(net.minecraft.init.Items.fish, new ItemStack(net.minecraft.init.Items.cooked_fished), 0.1F);
		OvenRecipeHandler.INSTANCE.addItemRecipe(net.minecraft.init.Items.porkchop, new ItemStack(net.minecraft.init.Items.cooked_porkchop), 0.35F);
		OvenRecipeHandler.INSTANCE.addItemRecipe(net.minecraft.init.Items.beef, new ItemStack(net.minecraft.init.Items.cooked_beef), 0.35F);
		OvenRecipeHandler.INSTANCE.addItemRecipe(net.minecraft.init.Items.chicken, new ItemStack(net.minecraft.init.Items.cooked_chicken), 0.35F);
		
		//Add each type of fish
		ItemFishFood.FishType[] afishtype = ItemFishFood.FishType.values();
        int i = afishtype.length;

        for (int j = 0; j < i; ++j)
        {
            ItemFishFood.FishType fishtype = afishtype[j];

            if (fishtype.func_150973_i())
            {
            	OvenRecipeHandler.INSTANCE.addRecipeToList(new ItemStack(net.minecraft.init.Items.fish, 1, fishtype.func_150976_a()), new ItemStack(net.minecraft.init.Items.cooked_fished, 1, fishtype.func_150976_a()), 0.35F);
            }
        }
	}
	
	private void addBucket()
	{
		BucketHandler.INSTANCE.buckets.put(Blocks.blockFluidDistilledWater, Items.itemBucketDistilledWater);
	}
}
