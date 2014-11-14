package roboguy99.foodTech.client.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class OutputSlot extends Slot
{
	
	public OutputSlot(IInventory inventory, int id, int x, int y)
	{
		super(inventory, id, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		return false;
	}
}
