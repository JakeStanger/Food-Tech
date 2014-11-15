package roboguy99.foodTech.common.block;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.common.block.apparatus.BlockBowl;
import roboguy99.foodTech.common.block.apparatus.BlockChoppingBoard;
import roboguy99.foodTech.common.block.apparatus.BlockFryingPan;
import roboguy99.foodTech.common.block.apparatus.BlockKettle;
import roboguy99.foodTech.common.block.apparatus.BlockSaucepan;
import roboguy99.foodTech.common.block.machine.advanced.BlockDistiller;
import roboguy99.foodTech.common.block.machine.advanced.BlockGrill;
import roboguy99.foodTech.common.block.machine.advanced.BlockOven;
import roboguy99.foodTech.common.block.machine.basic.BlockCampfire;
import roboguy99.foodTech.common.block.machine.basic.BlockChurn;
import roboguy99.foodTech.common.block.machine.basic.BlockGrindstone;
import roboguy99.foodTech.common.block.multi.BlockWindTurbine;
import roboguy99.foodTech.common.block.multi.BlockWindmill;
import roboguy99.foodTech.common.block.prefab.BaseBlock;
import roboguy99.foodTech.common.block.prefab.TileBlock;
import roboguy99.foodTech.common.block.worldgen.BlockGas;
import roboguy99.foodTech.common.fluid.BlockFluidDistilledWater;
import roboguy99.foodTech.common.fluid.Fluids;
import roboguy99.foodTech.util.GeneratorData;
import roboguy99.foodTech.util.Tooltip;

public class Blocks
{
	//Multi-BaseBlock machines
	public static TileBlock blockWindTurbine;
	public static TileBlock blockWindmill;
	
	//Basic machines
	public static TileBlock blockGrindstone;
	public static TileBlock blockCampfire;
	public static TileBlock blockChurn;
	
	//Advanced machines
	public static TileBlock blockDistiller;
	public static TileBlock blockGrill;
	public static TileBlock blockOven;
	
	//Cooking apparatus
	public static TileBlock blockBowl;
	public static TileBlock blockKettle;
	public static TileBlock blockSaucepan;
	public static TileBlock blockFryingPan;
	public static TileBlock blockChoppingBoard;
	
	//Worldgen
	public static BaseBlock blockGas;
	
	//Fluids
	public static BlockFluidClassic blockFluidDistilledWater;
	
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
		blockSaucepan = new BlockSaucepan(Material.iron, "blockSaucepan");
		blockFryingPan = new BlockFryingPan(Material.iron, "blockFryingPan");
		blockChoppingBoard = new BlockChoppingBoard(Material.wood, "blockChoppingBoard");
		
		blockGas = new BlockGas(Material.glass, "blockGas");
		
		blockFluidDistilledWater = new BlockFluidDistilledWater(Fluids.fluidDistilledWater, Material.water);
	}
}
