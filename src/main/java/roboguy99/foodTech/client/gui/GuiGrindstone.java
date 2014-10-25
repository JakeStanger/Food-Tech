package roboguy99.foodTech.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import roboguy99.foodTech.client.gui.container.ContainerGrindstone;
import roboguy99.foodTech.common.tile.TileGrindstone;

public class GuiGrindstone extends GuiContainer
{
public final ResourceLocation texture = new ResourceLocation("roboguy99", "textures/gui/grindstone.png");
	
	private TileGrindstone grindstone;
	
	private static final int LEFT_INDENT = 57;
	private static final int TOP_INDENT = 37;
	private static final int LEFT_INDENT_TEXTURE = 176;
	private static final int TEXTURE_WIDTH = 14;
	private static final int TEXTURE_HEIGHT = 14;
	
	public GuiGrindstone(InventoryPlayer inventoryPlayer, TileGrindstone grindstone)
	{
		super(new ContainerGrindstone(inventoryPlayer, grindstone));
		
		this.grindstone = grindstone;
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		//Draw the gui screen
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		//Stone bar
		int i = (int) this.grindstone.getStoneScaled(14);
		drawTexturedModalRect(guiLeft+LEFT_INDENT, guiTop+TOP_INDENT+TEXTURE_HEIGHT-i, LEFT_INDENT_TEXTURE, TEXTURE_HEIGHT-i, TEXTURE_WIDTH, i);
	}
}
