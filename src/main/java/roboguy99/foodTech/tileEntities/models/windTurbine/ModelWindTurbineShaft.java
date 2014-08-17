package roboguy99.foodTech.tileEntities.models.windTurbine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWindTurbineShaft extends ModelBase
{
  //fields
    ModelRenderer Main;
    ModelRenderer EdgeLeft;
    ModelRenderer EdgeRight;
    ModelRenderer EdgeBack;
    ModelRenderer EdgeFront;
  
  public ModelWindTurbineShaft()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Main = new ModelRenderer(this, 0, 0);
      Main.addBox(0F, 0F, 0F, 6, 16, 6);
      Main.setRotationPoint(-3F, 8F, -3F);
      Main.setTextureSize(128, 32);
      Main.mirror = true;
      setRotation(Main, 0F, 0F, 0F);
      EdgeLeft = new ModelRenderer(this, 36, 0);
      EdgeLeft.addBox(0F, 0F, 0F, 1, 16, 4);
      EdgeLeft.setRotationPoint(3F, 8F, -2F);
      EdgeLeft.setTextureSize(128, 32);
      EdgeLeft.mirror = true;
      setRotation(EdgeLeft, 0F, 0F, 0F);
      EdgeRight = new ModelRenderer(this, 58, 0);
      EdgeRight.addBox(0F, 0F, 0F, 1, 16, 4);
      EdgeRight.setRotationPoint(-4F, 8F, -2F);
      EdgeRight.setTextureSize(128, 32);
      EdgeRight.mirror = true;
      setRotation(EdgeRight, 0F, 0F, 0F);
      EdgeBack = new ModelRenderer(this, 47, 0);
      EdgeBack.addBox(0F, 0F, 0F, 4, 16, 1);
      EdgeBack.setRotationPoint(-2F, 8F, 3F);
      EdgeBack.setTextureSize(128, 32);
      EdgeBack.mirror = true;
      setRotation(EdgeBack, 0F, 0F, 0F);
      EdgeFront = new ModelRenderer(this, 25, 0);
      EdgeFront.addBox(0F, 0F, 0F, 4, 16, 1);
      EdgeFront.setRotationPoint(-2F, 8F, -4F);
      EdgeFront.setTextureSize(128, 32);
      EdgeFront.mirror = true;
      setRotation(EdgeFront, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Main.render(f5);
    EdgeLeft.render(f5);
    EdgeRight.render(f5);
    EdgeBack.render(f5);
    EdgeFront.render(f5);
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
