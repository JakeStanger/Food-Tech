package roboguy99.foodTech.client.render.block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import roboguy99.foodTech.client.model.windTurbine.ModelWindTurbineBase;
import roboguy99.foodTech.client.model.windTurbine.ModelWindTurbineShaft;
import roboguy99.foodTech.client.model.windTurbine.ModelWindTurbineTop;
import roboguy99.foodTech.client.model.windTurbine.ModelWindTurbineTopBlade;
import roboguy99.foodTech.common.block.Blocks;

public class RenderWindTurbine extends TileEntitySpecialRenderer //Tells OpenGL how the windTurbine tileEntity should be drawn
{
	private final ResourceLocation textureWindTurbineBase = new ResourceLocation("roboguy99", "textures/models/windTurbineBase.png");
	private final ResourceLocation textureWindTurbineShaft = new ResourceLocation("roboguy99", "textures/models/windTurbineShaft.png");
	private final ResourceLocation textureWindTurbineTop = new ResourceLocation("roboguy99", "textures/models/windTurbineTop.png");
	
	private final ModelWindTurbineBase modelBase;
	private final ModelWindTurbineShaft modelShaft;
	private final ModelWindTurbineTop modelTop;
	private final ModelWindTurbineTopBlade modelTopBlade;
	
	public RenderWindTurbine()
	{
		this.modelBase = new ModelWindTurbineBase();
		this.modelShaft = new ModelWindTurbineShaft();
		this.modelTop = new ModelWindTurbineTop();
		this.modelTopBlade = new ModelWindTurbineTopBlade();
	}
	
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) //TODO fix rendering positions
	{	
		int x1 = tileEntity.xCoord;
		int y1 = tileEntity.yCoord;
		int z1 = tileEntity.zCoord;
		
		Minecraft minecraft = Minecraft.getMinecraft();
		
		while(tileEntity.getWorldObj().getBlockMetadata(x1, y1, z1) < 7 && tileEntity.getWorldObj().getBlock(x1, y1, z1).equals(Blocks.blockWindTurbine))
		{
			y1++;
		}
		
		int metadata = tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
		
		if(metadata == 1)
		{
			GL11.glPushMatrix();
			  Minecraft.getMinecraft().renderEngine.bindTexture(textureWindTurbineBase);
			  GL11.glTranslatef((float) x+1F, (float) y+0.06F, (float) z);
			  GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			  this.modelBase.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		   GL11.glPopMatrix();
		}
		if(metadata > 1 && metadata < 7)
		{
			GL11.glPushMatrix();
			  Minecraft.getMinecraft().renderEngine.bindTexture(textureWindTurbineShaft);
			  GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			  GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			  this.modelShaft.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		   GL11.glPopMatrix();
		}
		if (metadata > 7)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(textureWindTurbineTop);
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
			this.modelTop.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			
			
			float time = 0;
			if(minecraft.theWorld != null)
			{
				time = (float)Minecraft.getMinecraft().theWorld.getWorldTime();
			}
			
			float mult = 2F; //adjust this value to get the desired rotation speed
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 7.0F/16F, (float) z + 0.5F);
			GL11.glRotatef(time * mult, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(0, -15.0F/16F, 0);
			this.modelTopBlade.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}
}
