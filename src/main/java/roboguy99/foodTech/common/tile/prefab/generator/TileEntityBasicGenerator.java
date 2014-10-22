package roboguy99.foodTech.common.tile.prefab.generator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyProvider;

public abstract class TileEntityBasicGenerator extends TileEntity implements IEnergyHandler, IEnergyProvider
{
	protected EnergyStorage storage = new EnergyStorage(10000);
	public int output;
	public int generated;
	
	public TileEntityBasicGenerator(int output, int generated)
	{
		this.output = output;
		this.generated = generated;
		storage.setMaxReceive(0);
		storage.setMaxExtract(output);
		storage.setMaxTransfer(output);
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from)
	{
		return true;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate)
	{
		return 0;
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate)
	{
		return storage.extractEnergy(storage.getMaxExtract(), simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from)
	{
		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from)
	{
		return storage.getMaxEnergyStored();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) 
	{

		super.readFromNBT(nbt);
		storage.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) 
	{

		super.writeToNBT(nbt);
		storage.writeToNBT(nbt);
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		generate();
	}
	
	protected abstract void generate();
}
