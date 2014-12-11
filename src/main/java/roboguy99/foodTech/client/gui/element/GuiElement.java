package roboguy99.foodTech.client.gui.element;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiElement
{
	protected int textureStartX;
	protected int textureStartY;
	protected int textureHeight;
	protected int textureWidth;
	protected float zLevel;
	protected int x;
	protected int y;
	protected int progress = 0;
	
	public static final Minecraft MINECRAFT = Minecraft.getMinecraft();
	private ResourceLocation texture;
	
	/**
	 * A smaller part of a GUI screen, specifically progress bars
	 * @param texture the texture file
	 * @param x the x position of where to start rendering
	 * @param y the y position of where to start rendering
	 * @param textureStartX the X pos at which to read the progress bar from the image file
	 * @param textureStartY the X pos at which to read the progress bar from the image file
	 * @param textureWidth the width of the bar
	 * @param textureHeight the height of the bar
	 * @param progress the progress scaled
	 * @param isVertical whether or not the progress bar is vertical. Used when calculating progress.
	 */
	public GuiElement(ResourceLocation texture, int x, int y, int textureStartX, int textureStartY, int textureWidth, int textureHeight)
	{	
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.textureStartX = textureStartX;
		this.textureStartY = textureStartY;
		this.textureHeight = textureHeight;
		this.textureWidth = textureWidth;
	}
	
	/**
	 * Used for vertical progress bars
	 */
	public void renderVertical()
	{
		MINECRAFT.getTextureManager().bindTexture(texture);
		
		this.drawTexturedModalRect(this.x, this.y, 
				0, 0, 
				this.textureWidth, this.textureHeight); //Draw the bar slot
		
		this.drawTexturedModalRect(x, y + this.textureHeight - this.progress, 
				this.textureStartX, this.textureStartY + this.textureHeight - progress, 
				this.textureWidth, this.progress); //Draw the progress bar in the slot
	}
	
	/**
	 * Used for horizontal progress bars
	 */
	public void renderHorizontal()
	{
		MINECRAFT.getTextureManager().bindTexture(texture);
		
		this.drawTexturedModalRect(this.x, this.y, 
				0, 0, 
				this.textureWidth, this.textureHeight); //Draw the bar slot
		
		this.drawTexturedModalRect(this.x, this.y, 
				this.textureStartX, this.textureStartY, 
				this.progress, this.textureHeight); //Draw the progress bar in the slot
	}
	
	public void setProgress(int progress)
	{
		this.progress = progress;
	}
	
	/**
	 * Draw a GUI rectangle
	 * @param x
	 * @param y
	 * @param startX
	 * @param startY
	 * @param width
	 * @param height
	 */
    private void drawTexturedModalRect(int x, int y, int startX, int startY, int width, int height)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + height), (double)this.zLevel, (double)((float)(startX + 0) * f), (double)((float)(startY + height) * f1));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), (double)this.zLevel, (double)((float)(startX + width) * f), (double)((float)(startY + height) * f1));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + 0), (double)this.zLevel, (double)((float)(startX + width) * f), (double)((float)(startY + 0) * f1));
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(startX + 0) * f), (double)((float)(startY + 0) * f1));
        tessellator.draw();
    }
}
