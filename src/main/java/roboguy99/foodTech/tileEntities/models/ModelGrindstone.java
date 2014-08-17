package roboguy99.foodTech.tileEntities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGrindstone extends ModelBase
{
  //fields
    ModelRenderer Stone;
    ModelRenderer Handle1;
    ModelRenderer Handle2;
  
  public ModelGrindstone()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Stone = new ModelRenderer(this, 0, 0);
      Stone.addBox(0F, 0F, 0F, 14, 14, 14);
      Stone.setRotationPoint(-7F, 10F, -7F);
      Stone.setTextureSize(64, 32);
      Stone.mirror = true;
      setRotation(Stone, 0F, 0F, 0F);
      Handle1 = new ModelRenderer(this, 0, 0);
      Handle1.addBox(0F, 0F, 0F, 1, 4, 1);
      Handle1.setRotationPoint(0F, 6F, 0F);
      Handle1.setTextureSize(64, 32);
      Handle1.mirror = true;
      setRotation(Handle1, 0F, 0F, 0F);
      Handle2 = new ModelRenderer(this, 0, 0);
      Handle2.addBox(0F, 0F, 0F, 4, 1, 1);
      Handle2.setRotationPoint(-4F, 6F, 0F);
      Handle2.setTextureSize(64, 32);
      Handle2.mirror = true;
      setRotation(Handle2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Stone.render(f5);
    Handle1.render(f5);
    Handle2.render(f5);
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
