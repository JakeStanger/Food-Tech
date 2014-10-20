package roboguy99.foodTech.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import roboguy99.foodTech.client.models.ModelCable;
import roboguy99.foodTech.common.tile.electricity.wire.TileWire;

public class RenderCable extends TileEntitySpecialRenderer 
{
    ResourceLocation textureOff = (new ResourceLocation("roboguy99:textures/models/cableOff.png"));
    ResourceLocation textureOn = (new ResourceLocation("roboguy99:textures/models/cableOn.png"));
	
	public ModelCable modelCable;
	
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) 
	{
		boolean[] neighbourBlockWires = new boolean[6];
		
		GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(textureOff);
			
			/*neighbourBlockWires[0] = ((TileWire) tileEntity).getWireAboveConnected();
			neighbourBlockWires[1] = ((TileWire) tileEntity).getWireBelowConnected();
			neighbourBlockWires[2] = ((TileWire) tileEntity).getWireNorthConnected();
			neighbourBlockWires[3] = ((TileWire) tileEntity).getWireSouthConnected();
			neighbourBlockWires[4] = ((TileWire) tileEntity).getWireEastConnected();
			neighbourBlockWires[5] = ((TileWire) tileEntity).getWireWestConnected();*/
			
			this.modelCable = new ModelCable(neighbourBlockWires);
			
			this.modelCable.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			
			GL11.glTranslatef((float) x - 0.5F, (float) y + 0.5F, (float) z - 0.5F);
	    GL11.glPopMatrix();
	}
}