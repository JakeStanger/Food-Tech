package roboguy99.foodTech.common.item.prefab;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.util.Tooltip;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlock extends Item
{
	private Block block;
	
	public ItemBlock(String name, String textureName, Block block)
	{
		this.setUnlocalizedName(name);
		this.setCreativeTab(FoodTech.TAB_FOODTECH);
		this.setTextureName(textureName);
		GameRegistry.registerItem(this, name);
		
		this.block = block;
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2)
	{
		if(!world.isRemote && world.getBlock(x, y+1, z).isAir(world, x, y+1, z))
		{
			world.setBlock(x, y+1, z, this.block);
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(EnumChatFormatting.RED + Tooltip.MACHINE_ADVANCED);
	}
}
