package roboguy99.foodTech.common.event;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;

import org.lwjgl.opengl.GL11;

import roboguy99.foodTech.common.blocks.Blocks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class WindTurbineHighlightEvent 
{
	@SubscribeEvent
	public void onDrawHighlight(DrawBlockHighlightEvent event)
	{
		if(event.target.typeOfHit.equals(MovingObjectType.BLOCK) && event.player.worldObj.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ).equals(Blocks.blockWindTurbine))
		{
			if(event.player.worldObj.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ).equals(Blocks.blockWindTurbine))
			{
				onDrawHighlightWindmill(event);
			}
		}
	}
	
	public void onDrawHighlightWindmill(DrawBlockHighlightEvent event)
	{
		event.setCanceled(true);
		
		Block block = event.player.worldObj.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
		block.setBlockBoundsBasedOnState(event.player.worldObj, event.target.blockX, event.target.blockY, event.target.blockZ);
		
		double x = event.player.lastTickPosX + event.player.posX - event.player.lastTickPosX * event.partialTicks;
		double y = event.player.lastTickPosY + event.player.posY - event.player.lastTickPosY * event.partialTicks;
		double z = event.player.lastTickPosZ + event.player.posZ - event.player.lastTickPosZ * event.partialTicks;
		
		float f = 0.002F;
		
		AxisAlignedBB bounds = block.getSelectedBoundingBoxFromPool(event.player.worldObj, event.target.blockX, event.target.blockY, event.target.blockZ).expand(f, f, f).getOffsetBoundingBox(-x, -y, -z);
		
		int metadata = event.player.worldObj.getBlockMetadata(event.target.blockX, event.target.blockY, event.target.blockZ);
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(0, 0, 0, 0);
		GL11.glLineWidth(50);
		
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINES);
			tessellator.addVertex(bounds.minX, bounds.minY+(7-metadata), bounds.minZ);
			tessellator.addVertex(bounds.minX, bounds.maxY-metadata, bounds.minZ);
			tessellator.addVertex(bounds.maxX, bounds.minY+(7-metadata), bounds.minZ);
			tessellator.addVertex(bounds.maxX, bounds.maxY-metadata, bounds.minZ);
			tessellator.addVertex(bounds.minX, bounds.minY+(7-metadata), bounds.maxZ);
			tessellator.addVertex(bounds.minX, bounds.maxY-metadata, bounds.maxZ);
			tessellator.addVertex(bounds.maxX, bounds.minY+(7-metadata), bounds.maxZ);
			tessellator.addVertex(bounds.maxX, bounds.maxY-metadata, bounds.maxZ);
		tessellator.draw();
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	
	public void onDrawHighlightWindmillBase(DrawBlockHighlightEvent event)
	{
		event.setCanceled(true);
	}
}
