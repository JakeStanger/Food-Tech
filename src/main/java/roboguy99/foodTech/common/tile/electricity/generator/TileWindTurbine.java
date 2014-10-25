package roboguy99.foodTech.common.tile.electricity.generator;

import net.minecraftforge.common.util.ForgeDirection;
import roboguy99.foodTech.common.tile.prefab.generator.TileBasicGenerator;


public class TileWindTurbine extends TileBasicGenerator
{
	private boolean canGenerate;
	
	public TileWindTurbine(int generated, int buffer)
	{
		super(generated, buffer);
	}

	@Override
	protected void generate()
	{	
		this.canGenerate = false;
		
		if (worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) == 1)
		{
			for(int i = 7; i < 50; i++)
			{
				//Check a 3x3 area for 50 layers above the turbine to check it's air TODO fix this or implement a better system
				if(worldObj.isAirBlock(xCoord, yCoord+i, zCoord) && 
						worldObj.isAirBlock(xCoord+1, yCoord+i, zCoord) &&
						worldObj.isAirBlock(xCoord-1, yCoord+i, zCoord) &&
						worldObj.isAirBlock(xCoord, yCoord+i, zCoord+1) &&
						worldObj.isAirBlock(xCoord, yCoord+i, zCoord-1) &&
						worldObj.isAirBlock(xCoord+1, yCoord+i, zCoord+1) &&
						worldObj.isAirBlock(xCoord-1, yCoord+i, zCoord-1) &&
						worldObj.isAirBlock(xCoord-1, yCoord+i, zCoord+1) &&
						worldObj.isAirBlock(xCoord+1, yCoord+i, zCoord-1))
				{
					this.canGenerate = true;
				}
			}
		}
		if(this.canGenerate) 
		{
			storage.modifyEnergyStored(generated);
		}
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from)
	{
		if (from != ForgeDirection.UP) return true;
		else return false;
	}
	
}
