package roboguy99.foodTech.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import roboguy99.foodTech.client.model.ModelGrindstone;
import roboguy99.foodTech.util.ResourceManager;

public class RenderItemGrindstone implements IItemRenderer
{
	protected ModelGrindstone model = new ModelGrindstone();
	private final ResourceLocation texture = ResourceManager.GRINDSTONE;
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{	
		if(type == ItemRenderType.INVENTORY)
		{
			GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
				GL11.glTranslatef(0.0F, -1.0F, 0.0F);
				GL11.glScalef(1.0F, 1.0F, 1.0F);
	
			    this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
		else if(type == ItemRenderType.EQUIPPED)
		{
			GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
				GL11.glTranslatef(0.0F, -1.3F, -0.3F);
				GL11.glScalef(1.5F, 1.5F, 1.5F);
	
	            this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
		}
		else if(type == ItemRenderType.EQUIPPED_FIRST_PERSON)
		{
			GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
				GL11.glTranslatef(-0.5F, -2.0F, -1.0F);
				GL11.glScalef(1.5F, 1.5F, 1.5F);
	
	            this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
		}
		else if(type == ItemRenderType.ENTITY)
		{
			GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
				GL11.glTranslatef(0.0F, -1.0F, -0.0F);
				GL11.glScalef(0.7F, 0.7F, 0.7F);
	
	            this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
		}
	}
}
