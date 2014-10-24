package roboguy99.foodTech.common.item;

import net.minecraft.item.Item;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.common.item.foods.ItemFlour;
import cpw.mods.fml.common.registry.GameRegistry;

public class Items
{
	//Create variables for each of the items
	public static Item itemWindTurbine;
	public static Item itemDebug;
	public static Item itemGrindstone;
	
	public static final String TYPE_INGREDIENT = "Ingredient";
	
	//Foods
	public static Item itemFlour;
	
	public Items()
	{
		FoodTech.print("Loading items");
		
		//Create instances of all the items
		itemWindTurbine = new ItemWindTurbine();
		itemDebug = new ItemDebug();
		itemGrindstone = new ItemGrindstone();
		
		//Foods
		itemFlour = new ItemFlour();
		
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
		
		//Foods
		itemFlour.setUnlocalizedName("itemFlour");
	}
	
	public void setCreativeTabs() //Sets the creative tab for each item. TODO create custom creative tab
	{
		itemWindTurbine.setCreativeTab(FoodTech.tabFoodTech);
		itemDebug.setCreativeTab(FoodTech.tabFoodTech);
		itemGrindstone.setCreativeTab(FoodTech.tabFoodTech);
		itemFlour.setCreativeTab(FoodTech.tabFoodTech);
	}
	
	public void setTextureNames() //Loads the texture for each of the items. TODO Create textures for items
	{
		itemWindTurbine.setTextureName("diamond");
		itemDebug.setTextureName("diamond");
		itemGrindstone.setTextureName("diamond");
		itemFlour.setTextureName("diamond");
	}
	
	public void registerItems() //Adds the items into the game
	{
		GameRegistry.registerItem(itemWindTurbine, "iteWindTurbine");
		GameRegistry.registerItem(itemDebug, "itemDebug");
		GameRegistry.registerItem(itemGrindstone, "itemGrindstone");
		GameRegistry.registerItem(itemFlour, "itemFlour");
	}
}