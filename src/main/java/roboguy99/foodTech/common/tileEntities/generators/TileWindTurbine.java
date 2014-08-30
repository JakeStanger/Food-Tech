package roboguy99.foodTech.common.tileEntities.generators;

import net.minecraft.item.ItemStack;
import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.common.tileEntities.prefab.TileSingleSlotMachine;
import universalelectricity.api.UniversalClass;

@UniversalClass
public class TileWindTurbine extends TileSingleSlotMachine
{	
	public TileWindTurbine()
	{
		super();
		buffer().setCapacity(10000);
		buffer().setMaxReceive(0);
		buffer().setMaxExtract(100);
		buffer().setEnergy(0);
	}
	
	@Override
	public void updateEntity()
	{	
		if(this.getWorldObj().getBlockMetadata(xCoord, yCoord, zCoord) > 6)
		{
			buffer().setEnergy(buffer().getEnergy() + 10);
			FoodTech.print(buffer().getEnergy());
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
	public int getPowerScaled(int scaled)
	{
		return (int) (buffer().getEnergy() * scaled / buffer().getEnergyCapacity());
	}
}
