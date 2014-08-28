package roboguy99.foodTech.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDebug extends Item
{
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2)
	{
		System.out.println("Name: " + world.getBlock(x, y, z));
		System.out.println("Metadata: " + world.getBlockMetadata(x, y, z));
		return false;
	}
}
