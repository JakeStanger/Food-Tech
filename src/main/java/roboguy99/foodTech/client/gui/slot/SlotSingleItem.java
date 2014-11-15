package roboguy99.foodTech.client.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 * A slot which only allows 1 item to be placed inside of it.
 * Useful for things such as bucket slots.
 * @author Jake
 *
 */
public class SlotSingleItem extends Slot
{
	public SlotSingleItem(IInventory inventory, int id, int x, int y)
	{
		super(inventory, id, x, y);
	}
	
	public int getSlotStackLimit()
	{
		return 1;
	}
}
