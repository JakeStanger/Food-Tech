package roboguy99.foodTech.common.block;

import net.minecraft.block.material.Material;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.common.block.prefab.BaseBlock;
import roboguy99.foodTech.util.GeneratorData;
import roboguy99.foodTech.util.Tooltip;

public class Blocks
{
	//Multi-BaseBlock machines
	public static BaseBlock blockWindTurbine;
	public static BaseBlock blockWindmill;
	
	//Basic machines
	public static BaseBlock blockGrindstone;
	public static BaseBlock blockCampfire;
	public static BaseBlock blockChurn;
	
	//Advanced machines
	public static BaseBlock blockDistiller;
	public static BaseBlock blockGrill;
	public static BaseBlock blockOven;
	
	//Cooking apparatus
	public static BaseBlock blockBowl;
	public static BaseBlock blockKettle;
	
	//Worldgen
	public static BaseBlock blockGas;
	
	public Blocks()
	{
		FoodTech.print("Loading blocks");
		
		//Create instances of all of the blocks
		blockWindTurbine = new BlockWindTurbine(Material.iron, "blockWindTurbine", GeneratorData.TURBINE_GENERATED, GeneratorData.TURBINE_BUFFERSIZE, Tooltip.MACHINE_GENERATOR);
		blockWindmill = new BlockWindmill(Material.iron, "blockWindmill");
		
		blockGrindstone = new BlockGrindstone(Material.rock, "blockGrindstone");
		blockCampfire = new BlockCampfire(Material.wood, "blockCampfire");
		blockChurn = new BlockChurn(Material.iron, "blockChurn");
		
		blockDistiller = new BlockDistiller(Material.glass, "blockDistiller");
		blockGrill = new BlockGrill(Material.iron, "blockGrill");
		blockOven = new BlockOven(Material.iron, "blockOven");
		
		blockBowl = new BlockBowl(Material.wood, "blockBowl");
		blockKettle = new BlockKettle(Material.iron, "blockKettle");
		blockGas = new BlockGas(Material.air, "blockGas");
	}
}
