package roboguy99.foodTech.common.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import roboguy99.foodTech.common.block.Blocks;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldgenGas implements IWorldGenerator
{
	private static final int TIMES_PER_CHUNK = 5;
	private static final int GENERATION_HEIGHT = 32;
	private static final int BLOCKS_PER_VEIN = 10;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ)
	{
		
	}
	
	private void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		for(int i = 0; i < TIMES_PER_CHUNK; i++)
		{
			int randPosX = chunkX + random.nextInt(16);
			int randPosY = random.nextInt(GENERATION_HEIGHT);
			int randPosZ = chunkZ + random.nextInt(16);
			
			(new WorldGenMinable(Blocks.blockGas, BLOCKS_PER_VEIN)).generate(world, random, randPosX, randPosY, randPosZ);
		}
	}
	
	private void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{
		
	}
}
