package roboguy99.foodTech.common.item;

import net.minecraft.item.Item;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.common.block.Blocks;
import roboguy99.foodTech.common.item.bucket.Bucket;
import roboguy99.foodTech.common.item.foods.ingredients.ItemFlour;
import roboguy99.foodTech.common.item.foods.ingredients.ItemSalt;
import cpw.mods.fml.common.registry.GameRegistry;

public class Items
{
	//Create variables for each of the items
	public static Item itemWindTurbine;
	public static Item itemDebug;
	public static Item itemGrindstone;
	public static Item itemDistiller;
	
	public static final String TYPE_INGREDIENT = "Ingredient";
	
	//Ingredient
	public static Item itemFlour;
	public static Item itemSalt;
	
	//Buckets
	public static Bucket itemBucketDistilledWater;
	
	public Items()
	{
		FoodTech.print("Loading items");
		
		//Create instances of all the items
		itemWindTurbine = new ItemWindTurbine();
		itemDebug = new ItemDebug();
		itemGrindstone = new ItemGrindstone();
		itemDistiller = new ItemDistiller();
		
		//Ingredients
		itemFlour = new ItemFlour();
		itemSalt = new ItemSalt();
		
		//Buckets
		itemBucketDistilledWater = new Bucket(Blocks.blockFluidDistilledWater, "itemBucketDistilledWater");
		
		//Call property-setting functions
		setUnlocalizedNames();
		setCreativeTabs();
		setTextureNames();
		registerItems();
	}
	
	public void setUnlocalizedNames() //Sets the unlocalised names for each of the items
	{
		itemWindTurbine.setUnlocalizedName("itemWindTurbine");
		itemDebug.setUnlocalizedName("itemDebug");
		itemGrindstone.setUnlocalizedName("itemGrindstone");
		itemDistiller.setUnlocalizedName("itemDistiller");
		
		//Ingredients
		itemFlour.setUnlocalizedName("itemFlour");
		itemSalt.setUnlocalizedName("itemSalt");
	}
	
	public void setCreativeTabs() //Sets the creative tab for each item.
	{
		itemWindTurbine.setCreativeTab(FoodTech.TAB_FOODTECH);
		itemDebug.setCreativeTab(FoodTech.TAB_FOODTECH);
		itemGrindstone.setCreativeTab(FoodTech.TAB_FOODTECH);
		itemDistiller.setCreativeTab(FoodTech.TAB_FOODTECH);
		
		//Ingredients
		itemFlour.setCreativeTab(FoodTech.TAB_FOODTECH);
		itemSalt.setCreativeTab(FoodTech.TAB_FOODTECH);
	}
	
	public void setTextureNames() //Loads the texture for each of the items. TODO Create textures for items
	{
		itemWindTurbine.setTextureName("diamond");
		itemDebug.setTextureName("diamond");
		itemGrindstone.setTextureName("diamond");
		itemDistiller.setTextureName("diamond");
		
		//Ingredients
		itemFlour.setTextureName("diamond");
		itemSalt.setTextureName("diamond");
	}
	
	public void registerItems() //Adds the items into the game
	{
		GameRegistry.registerItem(itemWindTurbine, "iteWindTurbine");
		GameRegistry.registerItem(itemDebug, "itemDebug");
		GameRegistry.registerItem(itemGrindstone, "itemGrindstone");
		GameRegistry.registerItem(itemDistiller, "itemDistiller");
		
		//Ingredients
		GameRegistry.registerItem(itemFlour, "itemFlour");
		GameRegistry.registerItem(itemSalt, "itemSalt");
	}
}
