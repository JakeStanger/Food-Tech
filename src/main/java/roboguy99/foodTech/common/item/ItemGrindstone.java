package roboguy99.foodTech.common.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import roboguy99.foodTech.common.block.Blocks;

public class ItemGrindstone extends Item
{
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2)
	{
		if(!world.isRemote && world.getBlock(x, y+1, z).isAir(world, x, y+1, z))
		{
			world.setBlock(x, y+1, z, Blocks.blockGrindstone);
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(EnumChatFormatting.BLUE + Blocks.GRINDSTONE_MACHINETYPE);
	}
}
