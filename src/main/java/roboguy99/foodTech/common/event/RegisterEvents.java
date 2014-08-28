package roboguy99.foodTech.common.event;

import net.minecraftforge.common.MinecraftForge;

public class RegisterEvents 
{
	public RegisterEvents()
	{
		MinecraftForge.EVENT_BUS.register(new WindTurbineHighlightEvent());
	}
}
