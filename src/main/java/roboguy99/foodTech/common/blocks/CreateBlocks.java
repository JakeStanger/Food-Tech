package roboguy99.foodTech.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import roboguy99.foodTech.FoodTech;
import cpw.mods.fml.common.registry.GameRegistry;

public class CreateBlocks //Calls each of the custom block classes, creates any standard new blocks and sets the physical properties of the blocks
{
	//Create variables for each block
	public static Block blockWindTurbine;
	public static Block blockGrindstone;
	public static Block blockCable;
	
	public CreateBlocks()
	{
		FoodTech.print("Loading blocks");
		
		//Create instances of all of the blocks
		blockWindTurbine = new BlockWindTurbine(Material.iron);
		blockGrindstone = new BlockGrindstone(Material.rock);
		blockCable = new BlockWire(Material.iron);
		
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
		blockCable.setBlockName("blockCable");
	}
	
	public void setBlockTextureNames() //Loads the texture for each of the blocks
	{
		blockGrindstone.setBlockTextureName("roboguy99:blockGrindstone");
	}
	
	public void setCreativeTabs()
	{
		blockGrindstone.setCreativeTab(FoodTech.tabFoodTech);
		blockCable.setCreativeTab(FoodTech.tabFoodTech);
	}
	
	public void registerBlocks() //Adds the blocks to the game
	{
		GameRegistry.registerBlock(blockWindTurbine, "blockWindTurbine");
		GameRegistry.registerBlock(blockGrindstone, "blockGrindstone");
		GameRegistry.registerBlock(blockCable, "blockCable");
	}
}
