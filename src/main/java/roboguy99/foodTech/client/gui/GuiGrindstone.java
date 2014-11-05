package roboguy99.foodTech.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import roboguy99.foodTech.client.gui.container.ContainerGrindstone;
import roboguy99.foodTech.common.tile.TileGrindstone;
import roboguy99.foodTech.util.ResourceManager;

public class GuiGrindstone extends GuiContainer
{
	private final ResourceLocation texture = ResourceManager.GRINSTONE_GUI;
	
	private TileGrindstone grindstone;
	
	private static final int LEFT_INDENT_STONE = 57;
	private static final int TOP_INDENT_STONE = 37;
	private static final int LEFT_INDENT_TEXTURE_STONE = 176;
	private static final int TEXTURE_WIDTH_STONE = 14;
	private static final int TEXTURE_HEIGHT_STONE = 14;
	
	private static final int LEFT_INDENT_PROGRESS = 79;
	private static final int TOP_INDENT_PROGRESS = 35;
	private static final int LEFT_INDENT_TEXTURE_PROGRESS = 176;
	private static final int TOP_INDENT_TEXTURE_PROGRESS = 14;
	private static final int TEXTURE_HEIGHT_PROGRESS = 17;
	
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
		drawTexturedModalRect(this.guiLeft, this.guiTop,
				0, 0, 
				this.xSize, this.ySize);
		
		//Stone bar
		int i = (int) this.grindstone.getStoneScaled(14);
		drawTexturedModalRect(guiLeft+LEFT_INDENT_STONE, guiTop+TOP_INDENT_STONE+TEXTURE_HEIGHT_STONE-i, 
				LEFT_INDENT_TEXTURE_STONE, TEXTURE_HEIGHT_STONE-i, 
				TEXTURE_WIDTH_STONE, i);
		
        //Progress bar
		int i1 = this.grindstone.getProgressScaled(24);
        this.drawTexturedModalRect(guiLeft + LEFT_INDENT_PROGRESS, guiTop + TOP_INDENT_PROGRESS,
        		LEFT_INDENT_TEXTURE_PROGRESS, TOP_INDENT_TEXTURE_PROGRESS,
        		i1 + 1, TEXTURE_HEIGHT_PROGRESS);
	}
}
