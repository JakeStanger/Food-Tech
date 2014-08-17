package roboguy99.foodTech;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreateCreativeTabs extends CreativeTabs 
{
	public CreateCreativeTabs(int par1, String par2Str) 
	{
		super(15, "Awesome");
	}
	
	
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() 
	{
		return Items.apple;
	}
} //TODO create a creative tab
