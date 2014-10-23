package roboguy99.foodTech.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import roboguy99.foodTech.client.gui.container.ContainerGeneratorBasic;
import roboguy99.foodTech.common.tile.prefab.generator.TileBasicGenerator;

public class GuiGeneratorBasic extends GuiContainer
{
	public final ResourceLocation texture = new ResourceLocation("roboguy99", "textures/gui/generatorbasic.png");
	private TileBasicGenerator generator;
	
	public GuiGeneratorBasic(InventoryPlayer inventoryPlayer, TileBasicGenerator generator)
	
	{
		super(new ContainerGeneratorBasic(inventoryPlayer, generator));
		
		this.generator = generator;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		//Draw the gui screen
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		int i = (int) this.generator.getPowerScaled(162);
		System.out.println(i);
		drawTexturedModalRect(guiLeft+8, guiTop+11, 8, 168, i, 16); //Power contents bar
	}
}
