package roboguy99.foodTech.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import roboguy99.foodTech.client.gui.container.ContainerGrindstone;
import roboguy99.foodTech.common.tileEntities.TileEntityGrindstone;

public class GuiGrindstone extends GuiContainer
{
public final ResourceLocation texture = new ResourceLocation("roboguy99", "textures/gui/grindstone.png");
	
	private TileEntityGrindstone grindstone;
	
	
	public GuiGrindstone(InventoryPlayer inventoryPlayer, TileEntityGrindstone grindstone)
	{
		super(new ContainerGrindstone(inventoryPlayer, grindstone));
		
		this.grindstone = grindstone;
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		int i = (int) this.grindstone.getStoneScaled(14);
		drawTexturedModalRect(guiLeft+57, guiTop+14+37-i, 176, 14-i, 14, i); //Stone contents bar
	}
}
