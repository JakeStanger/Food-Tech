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
	private static final String GUI_ELEMENT_TEXTURE_PATH = "roboguy99:textures/gui/elements/";
	
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
	public static final ResourceLocation BLANK_GUI = new ResourceLocation(ResourceManager.GUI_TEXTURE_PATH + "blank.png");
	public static final ResourceLocation THREE_SLOT_MACHINE_GUI = new ResourceLocation(ResourceManager.GUI_TEXTURE_PATH + "threeSlotMachine.png");
	public static final ResourceLocation DISTILLER_GUI = new ResourceLocation(ResourceManager.GUI_TEXTURE_PATH + "distiller.png");
	
	//GUI elements
	public static final ResourceLocation FUEL_PROGRESS_GUI_ELEMENT = new ResourceLocation(ResourceManager.GUI_ELEMENT_TEXTURE_PATH + "fuelProgess.png");
	public static final ResourceLocation POWER_HORIZONTAL_LARGE_GUI_ELEMENT = new ResourceLocation(ResourceManager.GUI_ELEMENT_TEXTURE_PATH + "powerHorizontalLarge.png");
	public static final ResourceLocation PROGRESS_SMALL_GUI_ELEMENT = new ResourceLocation(ResourceManager.GUI_ELEMENT_TEXTURE_PATH + "progressSmall.png");
	public static final ResourceLocation TANK_VERTICAL_GUI_ELEMENT = new ResourceLocation(ResourceManager.GUI_ELEMENT_TEXTURE_PATH + "tankVertical.png");
	public static final ResourceLocation TANK_VERTICAL_SMALL_GUI_ELEMENT = new ResourceLocation(ResourceManager.GUI_ELEMENT_TEXTURE_PATH + "tankVerticalSmall.png");
	public static final ResourceLocation TEMPERATURE_HORIZONTAL_GUI_ELEMENT = new ResourceLocation(ResourceManager.GUI_ELEMENT_TEXTURE_PATH + "temperatureHorizontal.png");
}
