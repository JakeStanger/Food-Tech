package roboguy99.foodTech;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import roboguy99.foodTech.blocks.CreateBlocks;
import roboguy99.foodTech.event.RegisterEvents;
import roboguy99.foodTech.gui.GuiHandler;
import roboguy99.foodTech.items.CreateItems;
import roboguy99.foodTech.proxies.CommonProxy;
import roboguy99.foodTech.tileEntities.RegisterTileEntities;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Main.modID, version = Main.modVersion, name = Main.name)
public class Main 
{
	//Mod data. Fallback if mc-mod.info fails to load.
	public static final String modID = "Roboguy99FoodTech";
	public static final String modVersion = "0.0.1";
	public static final String name = "Food Tech";
	
	public static Main instance;
	
	@SidedProxy(clientSide = "roboguy99.foodTech.proxies.ClientProxy", serverSide = "roboguy99.foodTech.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) //Pre-initialization loading
	{					
		print("Loading pre-initialization stage");
	
		instance = this;
		
		//Loads common content into the game
		new CreateBlocks();
		new CreateItems();
		
		print("Pre-initialization stage loaded successfully");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) //Initialization loading
	{
		print("Initializing");
		
		//Loads client content into the game
		new RegisterTileEntities();
		new RegisterEvents();
		
		proxy.registerProxies(); //Load the proxies
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler()); //Load the GUI handler
		
		print("Initialization finished");
	}
	
	public static void print(Object message)
	{
		System.out.println("[Food Tech] " + message.toString());
	}
	
	 public static CreativeTabs tabFoodTech = new CreativeTabs("tabFoodTech") 
	 {

		public Item getTabIconItem() 
		{
			return Item.getItemFromBlock(CreateBlocks.blockGrindstone); //TODO: 
		}
	 };
}