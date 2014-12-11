package roboguy99.foodTech.client.gui.element;

import roboguy99.foodTech.util.ResourceManager;

public class GuiElementPowerHorizontalLarge extends GuiElement
{
	private static final int TEXTURE_WIDTH = 162;
	private static final int TEXTURE_HEIGHT = 32;
	
	private static final int PROGRESS_START_X = 0;
	private static final int PROGRESS_START_Y = 18;
	
	public GuiElementPowerHorizontalLarge(int x, int y)
	{
		super(ResourceManager.POWER_HORIZONTAL_LARGE_GUI_ELEMENT, x, y, PROGRESS_START_X, PROGRESS_START_Y, TEXTURE_WIDTH, TEXTURE_HEIGHT);
	}
	
}
