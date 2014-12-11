package roboguy99.foodTech.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import roboguy99.foodTech.client.gui.container.ContainerGeneratorBasic;
import roboguy99.foodTech.client.gui.element.GuiElementPowerHorizontalLarge;
import roboguy99.foodTech.common.tile.prefab.generator.TileBasicGenerator;
import roboguy99.foodTech.util.ResourceManager;

public class GuiGeneratorBasic extends GuiBase
{	
	private GuiElementPowerHorizontalLarge powerBar;
	
	public GuiGeneratorBasic(InventoryPlayer inventoryPlayer, TileBasicGenerator generator)
	{
		super(new ContainerGeneratorBasic(inventoryPlayer, generator), ResourceManager.BLANK_GUI);
		
		this.xSize = 176;
		this.ySize = 166;
		
		this.powerBar = new GuiElementPowerHorizontalLarge(this.guiLeft+7, this.guiLeft+48);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float tick, int mouseX, int mouseY)
	{
		MINECRAFT.getTextureManager().bindTexture(this.texture);
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		this.powerBar.renderHorizontal();
	}
}
