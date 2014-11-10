package roboguy99.foodTech.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import roboguy99.foodTech.client.gui.container.ContainerDistiller;
import roboguy99.foodTech.common.tile.TileDistiller;
import roboguy99.foodTech.util.ResourceManager;

public class GuiDistiller extends GuiContainer
{
	private TileDistiller distiller;
	
	private final ResourceLocation texture = ResourceManager.DISTILLER_GUI;
	
	private static final int WATER_LEFT_INDENT = 8;
	private static final int WATER_TOP_INDENT = 11;
	private static final int WATER_TEXTURE_LEFT_INDENT = 176;
	private static final int WATER_TEXTURE_TOP_INDENT = 31;
	private static final int WATER_TEXTURE_WIDTH = 17;
	private static final int WATER_TEXTURE_HEIGHT = 50;
	
	public GuiDistiller(InventoryPlayer inventoryPlayer, TileDistiller distiller)
	{
		super(new ContainerDistiller(inventoryPlayer, distiller));
		
		this.distiller = distiller;

		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		//Draw the gui screen
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(this.guiLeft, this.guiTop,
				0, 0, 
				this.xSize, this.ySize);
		
		//Draw the water bar
		int i = this.distiller.getWaterScaled(WATER_TEXTURE_HEIGHT);
		drawTexturedModalRect(guiLeft+WATER_LEFT_INDENT, guiTop+WATER_TOP_INDENT+WATER_TEXTURE_HEIGHT-i, 
				WATER_TEXTURE_LEFT_INDENT, WATER_TEXTURE_TOP_INDENT+WATER_TEXTURE_HEIGHT-i, 
				WATER_TEXTURE_WIDTH, i);
	}
}
