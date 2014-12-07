package roboguy99.foodTech.common.item.prefab;

import java.util.List;

import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.util.Tooltip;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemIngredient extends Item
{
	public ItemIngredient(String name, String textureName)
	{
		this.setUnlocalizedName(name);
		this.setCreativeTab(FoodTech.TAB_FOODTECH);
		this.setTextureName(textureName);
		GameRegistry.registerItem(this, name);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(EnumChatFormatting.BLUE + Tooltip.TYPE_INGREDIENT);
	}
}
