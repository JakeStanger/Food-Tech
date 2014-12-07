package roboguy99.foodTech.common.item.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import roboguy99.foodTech.common.item.prefab.ItemBlock;
import roboguy99.foodTech.util.Tooltip;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDistiller extends ItemBlock
{
	public ItemDistiller(String name, String textureName, Block block)
	{
		super(name, textureName, block);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(EnumChatFormatting.RED + Tooltip.MACHINE_ADVANCED);
	}
}
