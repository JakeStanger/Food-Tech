package roboguy99.foodTech.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.util.GeneratorData;
import roboguy99.foodTech.util.Tooltip;
import cpw.mods.fml.common.registry.GameRegistry;

public class Blocks
{
	//Create fields for each block
	public static Block blockWindTurbine;
	public static Block blockWindmill;
	
	public static Block blockGrindstone;
	public static Block blockCampfire;
	
	public static Block blockDistiller;
	public static Block blockGrill;
	public static Block blockOven;
	public static Block blockChurn;
	
	public static Block blockBowl;
	
	public Blocks()
	{
		FoodTech.print("Loading blocks");
		
		//Create instances of all of the blocks
		blockWindTurbine = new BlockWindTurbine(Material.iron, GeneratorData.TURBINE_GENERATED, GeneratorData.TURBINE_BUFFERSIZE, Tooltip.MACHINE_GENERATOR);
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
