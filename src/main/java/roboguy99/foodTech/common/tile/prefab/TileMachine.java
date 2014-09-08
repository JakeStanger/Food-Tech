package roboguy99.foodTech.common.tile.prefab;

import net.minecraftforge.common.util.ForgeDirection;
import universalelectricity.api.EnergyStorage;
import universalelectricity.api.core.grid.INode;
import universalelectricity.api.core.grid.INodeProvider;
import universalelectricity.api.core.grid.electric.IEnergyNode;
import universalelectricity.core.grid.node.NodeEnergy;

/**
 * Created by robert on 8/24/2014.
 */
public class TileMachine extends Tile implements INodeProvider
{
    String fuel;
    int bufferSize;
    int energyPerTick;
	
	public NodeEnergy energyNode;

    public TileMachine()
    {
        this.energyNode = new NodeEnergy(this);
        
        //Used for item metadata
        this.fuel = "";
        this.bufferSize = 0;
        this.energyPerTick = 0;
    }

    public EnergyStorage buffer()
    {
        return energyNode.buffer();
    }

    public double getEnergy()
    {
        return buffer().getEnergy();
    }

    public double getCapacity()
    {
        return buffer().getEnergyCapacity();
    }

    @Override
    public INode getNode(Class<? extends INode> nodeType, ForgeDirection from)
    {
        if(IEnergyNode.class.isAssignableFrom(nodeType) && energyNode.canConnect(from))
        {
            return energyNode;
        }
        return null;
    }

    @Override
    public void start()
    {
        energyNode.reconstruct();
    }

    @Override
    public void invalidate()
    {
        super.invalidate();
        energyNode.deconstruct();
    }
    
    public void setFuel(String fuel)
    {
    	this.fuel = fuel;
    }
    
    public void setBufferSize(int bufferSize)
    {
    	this.bufferSize = bufferSize;
    }
    
    public void setEnergyPerTick(int energyPerTick)
    {
    	this.energyPerTick = energyPerTick;
    }
    
    public String getFuel()
    {
    	return this.fuel;
    }
    
    public int getBufferSize()
    {
    	return this.bufferSize;
    }
    
    public int getEnergyPerTick()
    {
    	return this.energyPerTick;
    }
}