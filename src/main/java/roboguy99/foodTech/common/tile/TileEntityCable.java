package roboguy99.foodTech.common.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import roboguy99.foodTech.common.blocks.CreateBlocks;

public class TileEntityCable extends TileEntity 
{	
	private boolean isWireAbove = false;
	private boolean isWireBelow = false;
	private boolean isWireNorth = false;
	private boolean isWireSouth = false;
	private boolean isWireEast = false;
	private boolean isWireWest = false;
	private boolean[] allConnectionStates = new boolean[6];
	
	public void getAllConnectedWires(int x, int y, int z, World world)
	 { 
		if (world.getBlock(x, y+1, z).equals(CreateBlocks.blockCable)) this.isWireAbove = true;
		if (world.getBlock(x, y-1, z).equals(CreateBlocks.blockCable)) this.isWireBelow = true;
		if (world.getBlock(x, y, z+1).equals(CreateBlocks.blockCable)) this.isWireNorth = true;
		if (world.getBlock(x, y, z-1).equals(CreateBlocks.blockCable)) this.isWireSouth = true;
		if (world.getBlock(x+1, y, z+1).equals(CreateBlocks.blockCable)) this.isWireEast = true;
		if (world.getBlock(x-1, y, z-1).equals(CreateBlocks.blockCable)) this.isWireWest = true;
		
		this.allConnectionStates[0] = this.isWireAbove;
		this.allConnectionStates[1] = this.isWireBelow;
		this.allConnectionStates[2] = this.isWireNorth;
		this.allConnectionStates[3] = this.isWireSouth;
		this.allConnectionStates[4] = this.isWireEast;
		this.allConnectionStates[5] = this.isWireWest;
	 }
	 
	 public void readFromNBT(NBTTagCompound nbt)
	 {
		 super.readFromNBT(nbt);
		 
		 this.isWireAbove = nbt.getBoolean("isWireAbove");
		 this.isWireBelow = nbt.getBoolean("isWireBelow");
		 this.isWireNorth = nbt.getBoolean("isWireNorth");
		 this.isWireSouth = nbt.getBoolean("isWireSouth");
		 this.isWireEast = nbt.getBoolean("isWireEast");
		 this.isWireWest = nbt.getBoolean("isWireWest");
	 }
	 
	 public void writeToNBT(NBTTagCompound nbt)
	 {
		 super.writeToNBT(nbt);
		 
		 nbt.setBoolean("isWireAbove", isWireAbove);
		 nbt.setBoolean("isWireBelow", isWireBelow);
		 nbt.setBoolean("isWireNorth", isWireNorth);
		 nbt.setBoolean("isWireSouth", isWireSouth);
		 nbt.setBoolean("isWireEast", isWireEast);
		 nbt.setBoolean("isWireWest", isWireWest);
	 }
	 
	 public boolean getWireAboveConnected()
	 {
		 return this.isWireAbove;
	 }
	 public boolean getWireBelowConnected()
	 {
		 return this.isWireBelow;
	 }
	 public boolean getWireNorthConnected()
	 {
		 return this.isWireNorth;
	 }
	 public boolean getWireSouthConnected()
	 {
		 return this.isWireSouth;
	 }
	 public boolean getWireEastConnected()
	 {
		 return this.isWireEast;
	 }
	 public boolean getWireWestConnected()
	 {
		 return this.isWireWest;
	 }
}
