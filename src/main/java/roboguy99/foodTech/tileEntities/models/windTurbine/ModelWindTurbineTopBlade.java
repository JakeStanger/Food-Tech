package roboguy99.foodTech.tileEntities.models.windTurbine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWindTurbineTopBlade extends ModelBase
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
  
  public ModelWindTurbineTopBlade()
  {
    textureWidth = 128;
    textureHeight = 32;
 
      Shaft = new ModelRenderer(this, 49, 24);
      Shaft.addBox(0F, 0F, 0F, 2, 2, 5);
      Shaft.setRotationPoint(-1F, 14F, -13F);
      Shaft.setTextureSize(128, 32);
      Shaft.mirror = true;
      setRotation(Shaft, 0F, 0F, 0F);
      Shaft_end = new ModelRenderer(this, 0, 29);
      Shaft_end.addBox(0F, 0F, 0F, 2, 2, 1);
      Shaft_end.setRotationPoint(-1F, 14F, -14F);
      Shaft_end.setTextureSize(128, 32);
      Shaft_end.mirror = true;
      setRotation(Shaft_end, 0F, 0F, 0F);
      Right_blade = new ModelRenderer(this, 88, 0);
      Right_blade.addBox(0F, 0F, 0F, 18, 2, 1);
      Right_blade.setRotationPoint(1F, 14F, -14F);
      Right_blade.setTextureSize(128, 32);
      Right_blade.mirror = true;
      setRotation(Right_blade, 0F, 0F, 0F);
      Left_blade = new ModelRenderer(this, 49, 0);
      Left_blade.addBox(0F, 0F, 0F, 18, 2, 1);
      Left_blade.setRotationPoint(-19F, 14F, -14F);
      Left_blade.setTextureSize(128, 32);
      Left_blade.mirror = true;
      setRotation(Left_blade, 0F, 0F, 0F);
      Top_blade = new ModelRenderer(this, 49, 4);
      Top_blade.addBox(0F, 0F, 0F, 2, 18, 1);
      Top_blade.setRotationPoint(-1F, -4F, -14F);
      Top_blade.setTextureSize(128, 32);
      Top_blade.mirror = true;
      setRotation(Top_blade, 0F, 0F, 0F);
      Bottom_blade = new ModelRenderer(this, 56, 4);
      Bottom_blade.addBox(0F, 0F, 0F, 2, 18, 1);
      Bottom_blade.setRotationPoint(-1F, 16F, -14F);
      Bottom_blade.setTextureSize(128, 32);
      Bottom_blade.mirror = true;
      setRotation(Bottom_blade, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shaft.render(f5);
    Shaft_end.render(f5);
    Right_blade.render(f5);
    Left_blade.render(f5);
    Top_blade.render(f5);
    Bottom_blade.render(f5);
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
