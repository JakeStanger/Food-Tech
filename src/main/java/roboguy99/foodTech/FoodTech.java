package roboguy99.foodTech;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import roboguy99.foodTech.client.gui.GuiHandler;
import roboguy99.foodTech.common.block.Blocks;
import roboguy99.foodTech.common.event.RegisterEvents;
import roboguy99.foodTech.common.fluid.Fluids;
import roboguy99.foodTech.common.item.Items;
import roboguy99.foodTech.common.tile.RegisterTileEntities;
import roboguy99.foodTech.proxies.CommonProxy;
import roboguy99.foodTech.util.WorldGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * The main class
 * Food-Tech is a mod for Minecraft all about food. Rather than hunger being something you have to occasionally worry about, 
 * this mod aims to overhaul it that with an entirely new hunger system and introduce modular foods made in a more realistic but
 * hopefully still enjoyable fashion.
 * @author Roboguy99
 *
 */
@Mod(modid = FoodTech.modID, version = FoodTech.modVersion, name = FoodTech.name)
public class FoodTech 
{
	//Mod data. Fallback if mc-mod.info fails to load.
	public static final String modID = "Roboguy99FoodTech";
	public static final String modVersion = "0.0.1";
	public static final String name = "Food Tech";
	
	public static FoodTech instance;
	
	@SidedProxy(clientSide = "roboguy99.foodTech.proxies.ClientProxy", serverSide = "roboguy99.foodTech.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) //Pre-initialisation loading
	{					
		print("Loading pre-initialization stage");
		instance = this;
		new WorldGen();
		print("Pre-initialization stage loaded successfully");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) //Initialisation loading
	{
		print("Initializing");
		
		//Loads common content into the game
		new Fluids();
		new Blocks();
		new Items();
		
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
	
	 public static final CreativeTabs TAB_FOODTECH = new CreativeTabs("tabFoodTech") 
	 {

		public Item getTabIconItem() 
		{
			return Items.itemGrindstone;
		}
	 };
}

/*
Todo List:

Bugs:
FIXME Wind turbine power gen/GUI
FIXME Grindstone doesn't actually work (needs testing)

Short-Term todos:

Long-Term Goals:
GOAL Re-do GUI to be more modular
GOAL Create windmill
GOAL Create jug of water - compatible with forge liquid dictionary?
GOAL Add salt shaker
GOAL Create butter churn
GOAL Add yeast - natural on/around trees?
GOAL Create custom cable system
GOAL Override hunger system
GOAL Add gas harvestability
*/