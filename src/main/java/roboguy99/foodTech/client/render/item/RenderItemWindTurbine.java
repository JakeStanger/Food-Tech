package roboguy99.foodTech.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import roboguy99.foodTech.client.model.ModelPole;

public class RenderItemWindTurbine implements IItemRenderer
{
	protected ModelPole model = new ModelPole();
	private static RenderItem renderItem = new RenderItem();
	private final ResourceLocation texture = new ResourceLocation("roboguy99:textures/models/grindstone.png");
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return type == ItemRenderType.INVENTORY;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType var1, ItemStack var2, Object... var3)
	{
		
		//Texture
		IIcon icon = var2.getIconIndex();
		renderItem.renderIcon(0, 0, icon, 16, 16);
		
		//Render item
		GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			if (var3[0] != null && var3[0] instanceof EntityPlayer)
            {
                float var5;

	            if ((EntityPlayer)var3[0] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && (!(Minecraft.getMinecraft().currentScreen instanceof GuiInventory) && !(Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) || RenderManager.instance.playerViewY != 180.0F))
	            {
	               var5 = 0.7F;
	               GL11.glTranslatef(1.0F, 0.7F, 0.6F);
	               GL11.glScalef(var5, var5, var5);
	               GL11.glRotatef(205.0F, 0.0F, 0.0F, 1.0F);
	               GL11.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
	               GL11.glRotatef(-5.0F, 1.0F, 0.0F, 0.0F);
	            }
	            else
	            {
	                var5 = 0.3F;
	                GL11.glTranslatef(0.5F, 0.5F, 0.1F);
	                GL11.glScalef(var5, var5, var5);
	                GL11.glRotatef(190.0F, 0.0F, 0.0F, 1.0F);
	                GL11.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
	                GL11.glRotatef(-5.0F, 1.0F, 0.0F, 0.0F);
	            }
            }

            this.model.render((Entity)var3[0], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
	}
}
