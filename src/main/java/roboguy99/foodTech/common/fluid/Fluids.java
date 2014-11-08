package roboguy99.foodTech.common.fluid;

import roboguy99.foodTech.common.fluid.prefab.BaseFluid;


public class Fluids
{
	public static BaseFluid fluidDistilledWater;
	
	public Fluids()
	{
		fluidDistilledWater = new BaseFluid("fluidDistlliedWater", 10, 1000);
	}
}
