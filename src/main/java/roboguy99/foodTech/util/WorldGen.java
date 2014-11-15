package roboguy99.foodTech.util;

import roboguy99.foodTech.common.worldgen.WorldgenGas;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;


public class WorldGen
{
	public WorldGen()
	{
		this.registerWorldGen(new WorldgenGas(), 1);
	}
	
	private void registerWorldGen(IWorldGenerator worldGenerator, int weightedProbability)
	{
		GameRegistry.registerWorldGenerator(worldGenerator, weightedProbability);
	}
}

