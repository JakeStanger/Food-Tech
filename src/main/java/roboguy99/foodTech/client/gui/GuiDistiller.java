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
	private final ResourceLocation texture = ResourceManager.DISTILLER_GUI;
	
	public GuiDistiller(InventoryPlayer inventoryPlayer, TileDistiller distiller)
	{
		super(new ContainerDistiller(inventoryPlayer, distiller));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		//Draw the gui screen
				Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
				drawTexturedModalRect(this.guiLeft, this.guiTop,
						0, 0, 
						this.xSize, this.ySize);
	}
}
