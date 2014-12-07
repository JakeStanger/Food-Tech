package roboguy99.foodTech.common.item.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import roboguy99.foodTech.FoodTech;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemToolGas extends Item
{
	private static final int MAX_GAS = 3000;
	
	public ItemToolGas(String name)
	{
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
		this.setCreativeTab(FoodTech.TAB_FOODTECH);
		this.setMaxDamage(MAX_GAS);
		GameRegistry.registerItem(this, name);
	}
	
	public int getMaxGas()
	{
		return MAX_GAS;
	}
	
	/**
     * Determines if the durability bar should be rendered for this item.
     * Defaults to vanilla stack.isDamaged behavior.
     * But modders can use this for any data they wish.
     * 
     * @param stack The current Item Stack
     * @return True if it should render the 'durability' bar.
     */
    public boolean showDurabilityBar(ItemStack stack)
    {
        return true;
    }

    /**
     * Queries the percentage of the 'Durability' bar that should be drawn.
     * 
     * @param stack The current ItemStack
     * @return 1.0 for 100% 0 for 0%
     */
    public double getDurabilityForDisplay(ItemStack stack)
    {
        return 1 - ((double)stack.getItemDamage() / (double)stack.getMaxDamage());
    }
}
