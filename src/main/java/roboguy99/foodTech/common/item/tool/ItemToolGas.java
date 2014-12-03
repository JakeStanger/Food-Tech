package roboguy99.foodTech.common.item.tool;

import net.minecraft.item.Item;
import roboguy99.foodTech.FoodTech;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemToolGas extends Item
{
	public int storedGas = 0;
	
	public ItemToolGas(String name)
	{
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
		this.setCreativeTab(FoodTech.TAB_FOODTECH);
		GameRegistry.registerItem(this, name);
	}
}
