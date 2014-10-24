package roboguy99.foodTech.common.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import roboguy99.foodTech.common.block.Blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWindTurbine extends Item //When used, places BlockwindTurbine
{	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2)
	{
		if(!world.isRemote)
		{
			if(side == 1) //It can only be placed on the top of a block.
			{
				boolean notEnoughSpace = false;
				
				for(int x1 = -1; x1 < 1; x1++)
				{
					for(int z1 = -1; z1 < 1; z1++)
					{
						for(int y1 = 0; y1 < 7; y1++)
						{
							if(!world.isAirBlock(x+x1, y+y1+1, z+z1)) notEnoughSpace = true;
						}
					}
				}
				
				if(!notEnoughSpace)
				{
					int direction = (-(int)player.rotationYaw+45)/90;
					if (direction == 0) direction = 4;
					
					for(int y1 = 0; y1 < 7; y1++)
					{
						world.setBlock(x, y+y1+1, z, Blocks.blockWindTurbine, (y1+1)==7?(y1+1+direction):(y1+1), 2);
					}
					return true;
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(EnumChatFormatting.BLUE + "Electrical generator");
		list.add(EnumChatFormatting.GREEN + "Fuel requied: " + EnumChatFormatting.AQUA + "Electricity"); //TODO: Get metadata from tile entity
		list.add(EnumChatFormatting.GREEN + "Buffer size: " + EnumChatFormatting.AQUA + "5000");
		list.add(EnumChatFormatting.GREEN + "Energy per tick: " + EnumChatFormatting.AQUA + "+10");
	}
	
	@SuppressWarnings("unused")
	private String setMetadata()
	{
		return "YOFACE";
	}
}
