package roboguy99.foodTech.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import roboguy99.foodTech.FoodTech;
import cpw.mods.fml.common.registry.GameRegistry;

public class Blocks
{
	//Create variables for each block
	public static Block blockWindTurbine;
	public static Block blockGrindstone;
	
	public Blocks()
	{
		FoodTech.print("Loading blocks");
		
		//Create instances of all of the blocks
		blockWindTurbine = new BlockWindTurbine(Material.iron);
		blockGrindstone = new BlockGrindstone(Material.rock);
		
		//Call property-setting functions
		setBlockNames();
		setBlockTextureNames();
		setCreativeTabs();;
		registerBlocks();
	}

	public void setBlockNames() //Sets the unlocalised name for each of the blocks.
	{
		blockWindTurbine.setBlockName("blockWindTurbine");
		blockGrindstone.setBlockName("blockGrindstone");
	}
	
	public void setBlockTextureNames() //Loads the texture for each of the blocks
	{
		blockGrindstone.setBlockTextureName("roboguy99:blockGrindstone");
	}
	
	public void setCreativeTabs()
	{
		blockGrindstone.setCreativeTab(FoodTech.tabFoodTech);
	}
	
	public void registerBlocks() //Adds the blocks to the game
	{
		GameRegistry.registerBlock(blockWindTurbine, "blockWindTurbine");
		GameRegistry.registerBlock(blockGrindstone, "blockGrindstone");
	}
}
