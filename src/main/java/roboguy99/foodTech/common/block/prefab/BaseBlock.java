package roboguy99.foodTech.common.block.prefab;

import roboguy99.foodTech.FoodTech;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BaseBlock extends Block
{
	protected BaseBlock(Material material, String name)
	{
		super(material);
		this.setBlockName(name);
		this.setCreativeTab(FoodTech.TAB_FOODTECH);
		GameRegistry.registerBlock(this, name);
	}
}
