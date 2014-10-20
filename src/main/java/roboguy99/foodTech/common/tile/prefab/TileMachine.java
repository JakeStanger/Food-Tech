package roboguy99.foodTech.common.tile.prefab;


/**
 * Created by robert on 8/24/2014.
 */
public class TileMachine extends Tile
{
    String fuel;
    int bufferSize;
    int energyPerTick;

    public TileMachine()
    {
        
        //Used for item metadata
        this.fuel = "";
        this.bufferSize = 0;
        this.energyPerTick = 0;
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