package roboguy99.foodTech.tileEntities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOven extends ModelBase
{
  //fields
    ModelRenderer Oven;
    ModelRenderer Dial_1;
    ModelRenderer Dial_2;
    ModelRenderer Handle_1;
    ModelRenderer Handle_2;
    ModelRenderer Handle_3;
  
  public ModelOven()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Oven = new ModelRenderer(this, 0, 0);
      Oven.addBox(0F, 0F, -1F, 16, 16, 16);
      Oven.setRotationPoint(-8F, 8F, -7F);
      Oven.setTextureSize(128, 32);
      Oven.mirror = true;
      setRotation(Oven, 0F, 0F, 0F);
      Dial_1 = new ModelRenderer(this, 48, 3);
      Dial_1.addBox(0F, 0F, 0F, 2, 2, 1);
      Dial_1.setRotationPoint(-6F, 9F, -9F);
      Dial_1.setTextureSize(128, 32);
      Dial_1.mirror = true;
      setRotation(Dial_1, 0F, 0F, 0F);
      Dial_2 = new ModelRenderer(this, 55, 3);
      Dial_2.addBox(0F, 0F, -9F, 2, 2, 1);
      Dial_2.setRotationPoint(4F, 9F, 0F);
      Dial_2.setTextureSize(128, 32);
      Dial_2.mirror = true;
      setRotation(Dial_2, 0F, 0F, 0F);
      Handle_1 = new ModelRenderer(this, 55, 7);
      Handle_1.addBox(0F, 0F, 0F, 1, 1, 2);
      Handle_1.setRotationPoint(5F, 14F, -10F);
      Handle_1.setTextureSize(128, 32);
      Handle_1.mirror = true;
      setRotation(Handle_1, 0F, 0F, 0F);
      Handle_2 = new ModelRenderer(this, 48, 7);
      Handle_2.addBox(0F, 0F, 0F, 1, 1, 2);
      Handle_2.setRotationPoint(-5F, 14F, -10F);
      Handle_2.setTextureSize(128, 32);
      Handle_2.mirror = true;
      setRotation(Handle_2, 0F, 0F, 0F);
      Handle_3 = new ModelRenderer(this, 48, 0);
      Handle_3.addBox(0F, 0F, 0F, 11, 1, 1);
      Handle_3.setRotationPoint(-5F, 14F, -11F);
      Handle_3.setTextureSize(128, 32);
      Handle_3.mirror = true;
      setRotation(Handle_3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Oven.render(f5);
    Dial_1.render(f5);
    Dial_2.render(f5);
    Handle_1.render(f5);
    Handle_2.render(f5);
    Handle_3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
