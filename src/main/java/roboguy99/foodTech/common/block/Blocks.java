package roboguy99.foodTech.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import roboguy99.foodTech.FoodTech;
import cpw.mods.fml.common.registry.GameRegistry;

public class Blocks
{
	//Create variables for each block
	public static Block blockWindTurbine;
	public static Block blockGrindstone;
	public static Block blockDistiller;
	
	//Constants for wind turbine
	public final static int TURBINE_GENERATED = 50;
	public final static int TURBINE_BUFFERSIZE = 10000;
	
	//Constants for machine types
	public final static String MACHINE_BASIC = "Basic machine";
	public final static String MACHINE_GENERATOR = "Electric Generator";
	public final static String MACHINE_ADVANCED = "Advanced machine";
	
	public Blocks()
	{
		FoodTech.print("Loading blocks");
		
		//Create instances of all of the blocks
		blockWindTurbine = new BlockWindTurbine(Material.iron, Blocks.TURBINE_GENERATED, Blocks.TURBINE_BUFFERSIZE, Blocks.MACHINE_GENERATOR);
		blockGrindstone = new BlockGrindstone(Material.rock);
		blockDistiller = new BlockDistiller(Material.glass);
		
		//Call property-setting functions
		setBlockNames();
		registerBlocks();
	}

	public void setBlockNames() //Sets the unlocalised name for each of the blocks.
	{
		blockWindTurbine.setBlockName("blockWindTurbine");
		blockGrindstone.setBlockName("blockGrindstone");
		blockDistiller.setBlockName("blockDistiller");
	}
	
	public void registerBlocks() //Adds the blocks to the game
	{
		GameRegistry.registerBlock(blockWindTurbine, "blockWindTurbine");
		GameRegistry.registerBlock(blockGrindstone, "blockGrindstone");
		GameRegistry.registerBlock(blockDistiller, "blockDistiller");
	}
}
