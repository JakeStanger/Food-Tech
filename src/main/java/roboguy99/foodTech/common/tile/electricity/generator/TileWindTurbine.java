package roboguy99.foodTech.common.tile.electricity.generator;

import net.minecraftforge.common.util.ForgeDirection;
import roboguy99.foodTech.common.tile.prefab.generator.TileBasicGenerator;


public class TileWindTurbine extends TileBasicGenerator
{

	public TileWindTurbine(int generated)
	{
		super(generated);
	}

	@Override
	protected void generate()
	{
		if (worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) == 1)
		{
			storage.modifyEnergyStored(generated); //TODO Check in "generatable" conditions
		}
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from)
	{
		if (from != ForgeDirection.UP) return true;
		else return false;
	}
	
}
