package roboguy99.foodTech.common.tile.electricity.generators;

import net.minecraft.item.ItemStack;
import roboguy99.foodTech.common.tile.prefab.TileSingleSlotMachine;

public class TileWindTurbine extends TileSingleSlotMachine
{	
	private int energyIncrement = 10;
	
	public TileWindTurbine()
	{
		super();
		
		this.setFuel("Electricity");
		this.setEnergyPerTick(this.energyIncrement);
	}
	
	@Override
	public void updateEntity()
	{	
		if(this.getWorldObj().getBlockMetadata(xCoord, yCoord, zCoord) > 6)
		{
			
		}
	}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack)
	{
		//TODO allow battery charging in generators
		return true;
	}
	
	@Override
	public String getInventoryName()
	{
		return "Wind Turbine";
	}
	
	/**
	 * Returns the power, scaled by a height value.
	 * Used for GUIs
	 * @param scaled
	 * @return
	 */
	/*public int getPowerScaled(int scaled)
	{
		return ENERGY * scaled / MAXENERGY
	}*/
}
