package roboguy99.foodTech.client.models.windTurbine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWindTurbineTop extends ModelBase
{
	//fields
    ModelRenderer Middle;
    ModelRenderer Blob1;
    ModelRenderer Blob2;
    public static ModelRenderer Shaft;
    public static ModelRenderer Shaft_end;
    public static ModelRenderer Right_blade;
    public static ModelRenderer Left_blade;
    public static ModelRenderer Top_blade;
    public static ModelRenderer Bottom_blade;
  
  public ModelWindTurbineTop()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Middle = new ModelRenderer(this, 0, 0);
      Middle.addBox(0F, 0F, 0F, 12, 16, 12);
      Middle.setRotationPoint(-6F, 8F, -6F);
      Middle.setTextureSize(128, 32);
      Middle.mirror = true;
      setRotation(Middle, 0F, 0F, 0F);
      Blob1 = new ModelRenderer(this, 64, 26);
      Blob1.addBox(0F, 0F, 0F, 4, 4, 1);
      Blob1.setRotationPoint(-2F, 13F, -7F);
      Blob1.setTextureSize(128, 32);
      Blob1.mirror = true;
      setRotation(Blob1, 0F, 0F, 0F);
      Blob2 = new ModelRenderer(this, 7, 29);
      Blob2.addBox(0F, 0F, 0F, 2, 2, 1);
      Blob2.setRotationPoint(-1F, 14F, -8F);
      Blob2.setTextureSize(128, 32);
      Blob2.mirror = true;
      setRotation(Blob2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Middle.render(f5);
    Blob1.render(f5);
    Blob2.render(f5);
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
