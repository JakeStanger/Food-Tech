package roboguy99.foodTech.common.items;

import net.minecraft.item.Item;
import roboguy99.foodTech.FoodTech;
import cpw.mods.fml.common.registry.GameRegistry;

public class CreateItems //Creates instances of any custom item classes, creates any standard items  and sets the properties of each item
{
	//Create variables for each of the items
	public static Item itemWindTurbine;
	public static Item itemDebug;
	
	public CreateItems()
	{
		FoodTech.print("Loading items");
		
		//Create instances of all the items
		itemWindTurbine = new ItemWindTurbine();
		itemDebug = new ItemDebug();
		
		//Call property-setting functions
		setUnlocalizedNames();
		setCreativeTabs();
		setTextureNames();
		registerItems();
	}
	
	public void setUnlocalizedNames() //Sets the unlocalized names for each of the items
	{
		itemWindTurbine.setUnlocalizedName("itemWindTurbine");
		itemDebug.setUnlocalizedName("itemDebug");
	}
	
	public void setCreativeTabs() //Sets the creative tab for each item. TODO create custom creative tab
	{
		itemWindTurbine.setCreativeTab(FoodTech.tabFoodTech);
		itemDebug.setCreativeTab(FoodTech.tabFoodTech);
	}
	
	public void setTextureNames() //Loads the texture for each of the items
	{
		itemWindTurbine.setTextureName("diamond");
		itemDebug.setTextureName("diamond");
	}
	
	public void registerItems() //Adds the items into the game
	{
		GameRegistry.registerItem(itemWindTurbine, "iteWindTurbine");
		GameRegistry.registerItem(itemDebug, "itemDebug");
	}
}
