package roboguy99.foodTech.util;

import net.minecraft.util.ResourceLocation;

/**
 * This class is purely for holding resource locations in one place for easy modification and
 * usage without having to search through multiple locations.
 * @author Roboguy99
 *
 */
public class ResourceManager
{
	public static final ResourceLocation GRINDSTONE = new ResourceLocation("roboguy99:textures/models/grindstone.png");
	public static final ResourceLocation DISTILLER = new ResourceLocation("roboguy99:textures/models/distiller.png");
	
	public static final ResourceLocation TURBINE_ITEM = new ResourceLocation("roboguy99:textures/models/grindstone.png"); //TODO create new texture
	
	public static final ResourceLocation TURBINE_BASE = new ResourceLocation("roboguy99", "textures/models/windTurbineBase.png");
	public static final ResourceLocation TURBINE_SHAFT = new ResourceLocation("roboguy99", "textures/models/windTurbineShaft.png");
	public static final ResourceLocation TURBINE_TOP = new ResourceLocation("roboguy99", "textures/models/windTurbineTop.png");
}
