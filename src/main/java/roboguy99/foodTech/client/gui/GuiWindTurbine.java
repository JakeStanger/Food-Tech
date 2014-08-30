package roboguy99.foodTech.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import roboguy99.foodTech.client.gui.container.ContainerWindTurbine;
import roboguy99.foodTech.common.tileEntities.generators.TileWindTurbine;

public class GuiWindTurbine extends GuiContainer
{
	public final ResourceLocation texture = new ResourceLocation("roboguy99", "textures/gui/windTurbine.png");
	
	private TileWindTurbine windTurbine;
	
	public GuiWindTurbine(InventoryPlayer inventoryPlayer, TileWindTurbine windTurbine) 
	{
		super(new ContainerWindTurbine(inventoryPlayer, windTurbine));
		
		this.windTurbine = windTurbine;
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize); //Main gui
		
		int i = (int) this.windTurbine.getPowerScaled(162);
		drawTexturedModalRect(guiLeft+7, guiTop+10, 0, 167, 7+i, 15); //Power bar
	}
		
}
