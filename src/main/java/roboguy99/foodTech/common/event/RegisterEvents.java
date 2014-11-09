package roboguy99.foodTech.common.event;

import net.minecraftforge.common.MinecraftForge;
import roboguy99.foodTech.util.BucketHandler;

public class RegisterEvents 
{
	public RegisterEvents()
	{
		MinecraftForge.EVENT_BUS.register(new WindTurbineHighlightEvent());
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
	}
}
