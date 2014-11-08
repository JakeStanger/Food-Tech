package roboguy99.foodTech.common.fluid.prefab;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BaseFluid extends Fluid
{
	public BaseFluid(String fluidName, int density, int viscosity)
	{
		super(fluidName);
		this.setDensity(density);
		this.setViscosity(viscosity);
		this.setUnlocalizedName(fluidName);
		FluidRegistry.registerFluid(this);
	}
}
