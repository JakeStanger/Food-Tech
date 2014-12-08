package roboguy99.foodTech.common.tile;

import roboguy99.foodTech.common.tile.prefab.TileThreeSlotMachine;

public class TileOven extends TileThreeSlotMachine
{
	private static final int PROCESS_TIME = 200;
	public int processTimeRemaining = TileOven.PROCESS_TIME;
	public int timeSpentProcessing = 0;
	private int furnaceBurnTime = 0;
	public int currentItemBurnTime = 0;
	
	public void updateEntity()
	{
		
	}
	
	@Override
	protected boolean canProcess()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void processItem()
	{
		// TODO Auto-generated method stub
		
	}
	
}
