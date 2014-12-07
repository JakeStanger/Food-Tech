package roboguy99.foodTech.common.item;

import net.minecraft.item.Item;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.common.block.Blocks;
import roboguy99.foodTech.common.item.block.ItemDistiller;
import roboguy99.foodTech.common.item.block.ItemGrindstone;
import roboguy99.foodTech.common.item.block.ItemWindTurbine;
import roboguy99.foodTech.common.item.foods.ingredients.ItemFlour;
import roboguy99.foodTech.common.item.foods.ingredients.ItemSalt;
import roboguy99.foodTech.common.item.prefab.Bucket;
import roboguy99.foodTech.common.item.prefab.ItemBlock;
import roboguy99.foodTech.common.item.prefab.ItemIngredient;
import roboguy99.foodTech.common.item.tool.ItemToolGas;

public class Items
{
	//Create fields for each of the items
	public static ItemBlock itemWindTurbine;
	public static ItemBlock itemDebug;
	public static ItemBlock itemGrindstone;
	public static ItemBlock itemDistiller;
	
	//Ingredient
	public static ItemIngredient itemFlour;
	public static ItemIngredient itemSalt;
	
	//Tools
	public static Item itemToolGas;
	
	//Buckets
	public static Bucket itemBucketDistilledWater;
	
	public Items()
	{
		FoodTech.print("Loading items");
		
		//Create instances of all the items
		itemWindTurbine = new ItemWindTurbine("itemBlockWindTurbine", "diamond", Blocks.blockWindTurbine);
		itemGrindstone = new ItemGrindstone("itemBlockGrindstone", "diamond", Blocks.blockGrindstone);
		itemDistiller = new ItemDistiller("itemBlockDistiller", "diamond", Blocks.blockDistiller);
		
		//Ingredients
		itemFlour = new ItemFlour("itemFlour", "diamond");
		itemSalt = new ItemSalt("itemSalt", "diamond");
		
		//Tools
		itemToolGas = new ItemToolGas("itemToolGas"); //ItemToolGas registers itself so can stay an item for now
		
		//Buckets
		itemBucketDistilledWater = new Bucket(Blocks.blockFluidDistilledWater, "itemBucketDistilledWater");
	}
}
