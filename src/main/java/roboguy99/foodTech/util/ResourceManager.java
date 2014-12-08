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
	//Standard paths
	private static final String MODEL_TEXTURE_PATH = "roboguy99:textures/models/";
	private static final String BLOCK_TEXTURE_PATH = "roboguy99:textures/blocks";
	private static final String GUI_TEXTURE_PATH = "roboguy99:textures/gui/";
	
	//Textures
	public static final ResourceLocation GRINDSTONE = new ResourceLocation(ResourceManager.MODEL_TEXTURE_PATH + "grindstone.png");
	public static final ResourceLocation DISTILLER = new ResourceLocation(ResourceManager.MODEL_TEXTURE_PATH + "distiller.png");
	public static final ResourceLocation OVEN = new ResourceLocation(ResourceManager.MODEL_TEXTURE_PATH + "oven.png");
	
	public static final ResourceLocation GAS = new ResourceLocation(ResourceManager.BLOCK_TEXTURE_PATH + "blockGas.png");
	
	public static final ResourceLocation TURBINE_ITEM = new ResourceLocation(ResourceManager.MODEL_TEXTURE_PATH + "grindstone.png"); //TODO create new texture
	
	public static final ResourceLocation TURBINE_BASE = new ResourceLocation(ResourceManager.MODEL_TEXTURE_PATH + "windTurbineBase.png");
	public static final ResourceLocation TURBINE_SHAFT = new ResourceLocation(ResourceManager.MODEL_TEXTURE_PATH + "windTurbineShaft.png");
	public static final ResourceLocation TURBINE_TOP = new ResourceLocation(ResourceManager.MODEL_TEXTURE_PATH + "windTurbineTop.png");
	
	//GUIs
	public static final ResourceLocation GRINSTONE_GUI = new ResourceLocation(ResourceManager.GUI_TEXTURE_PATH + "grindstone.png");
	public static final ResourceLocation DISTILLER_GUI = new ResourceLocation(ResourceManager.GUI_TEXTURE_PATH + "distiller.png");
}
