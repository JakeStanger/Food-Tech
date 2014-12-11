package roboguy99.foodTech.client.gui;

import roboguy99.foodTech.util.ResourceManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiBase extends GuiContainer
{	
	public static final Minecraft MINECRAFT = Minecraft.getMinecraft();
	protected ResourceLocation texture = ResourceManager.BLANK_GUI; //Emergency fallback to stop crashing
	
	public GuiBase(Container container, ResourceLocation texture)
	{
		super(container);

		this.xSize = 176;
		this.ySize = 166;
		this.texture = texture;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float tick, int mouseX, int mouseY)
	{
		MINECRAFT.getTextureManager().bindTexture(this.texture);
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
