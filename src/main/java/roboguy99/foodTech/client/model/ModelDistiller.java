package roboguy99.foodTech.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDistiller extends ModelBase
{
  //fields
    ModelRenderer chamber1base;
    ModelRenderer chamber1wall1;
    ModelRenderer chamber1wall2;
    ModelRenderer chamber1wall3;
    ModelRenderer chamber1wall4;
    ModelRenderer pipe1wall1;
    ModelRenderer pipe1wall2;
    ModelRenderer pipe1wall3;
    ModelRenderer pipe1wall4;
    ModelRenderer pipe1wall1part2;
    ModelRenderer thermometer;
    ModelRenderer pipe2wall1;
    ModelRenderer pipe2wall2;
    ModelRenderer pipe2wall3;
    ModelRenderer pipe2wall4;
    ModelRenderer condenser1;
    ModelRenderer condenser2;
    ModelRenderer condenser3;
    ModelRenderer condenser4;
    ModelRenderer chamber2base;
    ModelRenderer chamber2wall1;
    ModelRenderer chamber2wall2;
    ModelRenderer chamber2wall3;
    ModelRenderer chamber2wall4;
  
  public ModelDistiller()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      chamber1base = new ModelRenderer(this, 0, 0);
      chamber1base.addBox(0F, 0F, 0F, 5, 1, 5);
      chamber1base.setRotationPoint(-3F, 23F, 3F);
      chamber1base.setTextureSize(128, 32);
      chamber1base.mirror = true;
      setRotation(chamber1base, 0F, 0F, 0F);
      chamber1wall1 = new ModelRenderer(this, 0, 7);
      chamber1wall1.addBox(0F, 0F, 0F, 5, 3, 1);
      chamber1wall1.setRotationPoint(-3F, 20F, 7F);
      chamber1wall1.setTextureSize(128, 32);
      chamber1wall1.mirror = true;
      setRotation(chamber1wall1, 0F, 0F, 0F);
      chamber1wall2 = new ModelRenderer(this, 0, 12);
      chamber1wall2.addBox(0F, 0F, 0F, 5, 3, 1);
      chamber1wall2.setRotationPoint(-3F, 20F, 3F);
      chamber1wall2.setTextureSize(128, 32);
      chamber1wall2.mirror = true;
      setRotation(chamber1wall2, 0F, 0F, 0F);
      chamber1wall3 = new ModelRenderer(this, 0, 17);
      chamber1wall3.addBox(0F, 0F, 0F, 1, 3, 3);
      chamber1wall3.setRotationPoint(1F, 20F, 4F);
      chamber1wall3.setTextureSize(128, 32);
      chamber1wall3.mirror = true;
      setRotation(chamber1wall3, 0F, 0F, 0F);
      chamber1wall4 = new ModelRenderer(this, 0, 24);
      chamber1wall4.addBox(0F, 0F, 0F, 1, 3, 3);
      chamber1wall4.setRotationPoint(-3F, 20F, 4F);
      chamber1wall4.setTextureSize(128, 32);
      chamber1wall4.mirror = true;
      setRotation(chamber1wall4, 0F, 0F, 0F);
      pipe1wall1 = new ModelRenderer(this, 21, 0);
      pipe1wall1.addBox(0F, 0F, 0F, 1, 5, 1);
      pipe1wall1.setRotationPoint(-1F, 17F, 4F);
      pipe1wall1.setTextureSize(128, 32);
      pipe1wall1.mirror = true;
      setRotation(pipe1wall1, 0F, 0F, 0F);
      pipe1wall2 = new ModelRenderer(this, 21, 7);
      pipe1wall2.addBox(0F, 0F, 0F, 1, 7, 1);
      pipe1wall2.setRotationPoint(-1F, 15F, 6F);
      pipe1wall2.setTextureSize(128, 32);
      pipe1wall2.mirror = true;
      setRotation(pipe1wall2, 0F, 0F, 0F);
      pipe1wall3 = new ModelRenderer(this, 26, 0);
      pipe1wall3.addBox(0F, 0F, 0F, 1, 7, 1);
      pipe1wall3.setRotationPoint(0F, 15F, 5F);
      pipe1wall3.setTextureSize(128, 32);
      pipe1wall3.mirror = true;
      setRotation(pipe1wall3, 0F, 0F, 0F);
      pipe1wall4 = new ModelRenderer(this, 26, 9);
      pipe1wall4.addBox(0F, 0F, 0F, 1, 7, 1);
      pipe1wall4.setRotationPoint(-2F, 15F, 5F);
      pipe1wall4.setTextureSize(128, 32);
      pipe1wall4.mirror = true;
      setRotation(pipe1wall4, 0F, 0F, 0F);
      pipe1wall1part2 = new ModelRenderer(this, 15, 7);
      pipe1wall1part2.addBox(0F, 0F, 0F, 1, 1, 1);
      pipe1wall1part2.setRotationPoint(-1F, 15F, 4F);
      pipe1wall1part2.setTextureSize(128, 32);
      pipe1wall1part2.mirror = true;
      setRotation(pipe1wall1part2, 0F, 0F, 0F);
      thermometer = new ModelRenderer(this, 15, 10);
      thermometer.addBox(0F, 0F, 0F, 1, 8, 1);
      thermometer.setRotationPoint(-1F, 8F, 5F);
      thermometer.setTextureSize(128, 32);
      thermometer.mirror = true;
      setRotation(thermometer, 0F, 0F, 0F);
      pipe2wall1 = new ModelRenderer(this, 31, 0);
      pipe2wall1.addBox(0F, 0F, 0F, 1, 1, 11);
      pipe2wall1.setRotationPoint(0F, 16F, -6F);
      pipe2wall1.setTextureSize(128, 32);
      pipe2wall1.mirror = true;
      setRotation(pipe2wall1, 0F, 0F, 0F);
      pipe2wall2 = new ModelRenderer(this, 31, 13);
      pipe2wall2.addBox(0F, 0F, 0F, 1, 1, 11);
      pipe2wall2.setRotationPoint(-2F, 16F, -6F);
      pipe2wall2.setTextureSize(128, 32);
      pipe2wall2.mirror = true;
      setRotation(pipe2wall2, 0F, 0F, 0F);
      pipe2wall3 = new ModelRenderer(this, 56, 0);
      pipe2wall3.addBox(0F, 0F, 0F, 1, 1, 10);
      pipe2wall3.setRotationPoint(-1F, 15F, -6F);
      pipe2wall3.setTextureSize(128, 32);
      pipe2wall3.mirror = true;
      setRotation(pipe2wall3, 0F, 0F, 0F);
      pipe2wall4 = new ModelRenderer(this, 56, 12);
      pipe2wall4.addBox(0F, 0F, 0F, 1, 1, 9);
      pipe2wall4.setRotationPoint(-1F, 17F, -5F);
      pipe2wall4.setTextureSize(128, 32);
      pipe2wall4.mirror = true;
      setRotation(pipe2wall4, 0F, 0F, 0F);
      condenser1 = new ModelRenderer(this, 79, 0);
      condenser1.addBox(0F, 0F, 0F, 5, 1, 4);
      condenser1.setRotationPoint(-3F, 14F, -2F);
      condenser1.setTextureSize(128, 32);
      condenser1.mirror = true;
      setRotation(condenser1, 0F, 0F, 0F);
      condenser2 = new ModelRenderer(this, 79, 6);
      condenser2.addBox(0F, 0F, 0F, 5, 1, 4);
      condenser2.setRotationPoint(-3F, 18F, -2F);
      condenser2.setTextureSize(128, 32);
      condenser2.mirror = true;
      setRotation(condenser2, 0F, 0F, 0F);
      condenser3 = new ModelRenderer(this, 79, 12);
      condenser3.addBox(0F, 0F, 0F, 1, 3, 4);
      condenser3.setRotationPoint(1F, 15F, -2F);
      condenser3.setTextureSize(128, 32);
      condenser3.mirror = true;
      setRotation(condenser3, 0F, 0F, 0F);
      condenser4 = new ModelRenderer(this, 79, 20);
      condenser4.addBox(0F, 0F, 0F, 1, 3, 4);
      condenser4.setRotationPoint(-3F, 15F, -2F);
      condenser4.setTextureSize(128, 32);
      condenser4.mirror = true;
      setRotation(condenser4, 0F, 0F, 0F);
      chamber2base = new ModelRenderer(this, 98, 0);
      chamber2base.addBox(0F, 0F, 0F, 5, 1, 4);
      chamber2base.setRotationPoint(-3F, 23F, -8F);
      chamber2base.setTextureSize(128, 32);
      chamber2base.mirror = true;
      setRotation(chamber2base, 0F, 0F, 0F);
      chamber2wall1 = new ModelRenderer(this, 98, 6);
      chamber2wall1.addBox(0F, 0F, -1F, 1, 3, 4);
      chamber2wall1.setRotationPoint(1F, 20F, -7F);
      chamber2wall1.setTextureSize(128, 32);
      chamber2wall1.mirror = true;
      setRotation(chamber2wall1, 0F, 0F, 0F);
      chamber2wall2 = new ModelRenderer(this, 98, 14);
      chamber2wall2.addBox(0F, 0F, 0F, 1, 3, 4);
      chamber2wall2.setRotationPoint(-3F, 20F, -8F);
      chamber2wall2.setTextureSize(128, 32);
      chamber2wall2.mirror = true;
      setRotation(chamber2wall2, 0F, 0F, 0F);
      chamber2wall3 = new ModelRenderer(this, 98, 22);
      chamber2wall3.addBox(0F, 0F, 0F, 3, 3, 1);
      chamber2wall3.setRotationPoint(-2F, 20F, -8F);
      chamber2wall3.setTextureSize(128, 32);
      chamber2wall3.mirror = true;
      setRotation(chamber2wall3, 0F, 0F, 0F);
      chamber2wall4 = new ModelRenderer(this, 98, 27);
      chamber2wall4.addBox(0F, 0F, 0F, 3, 3, 1);
      chamber2wall4.setRotationPoint(-2F, 20F, -5F);
      chamber2wall4.setTextureSize(128, 32);
      chamber2wall4.mirror = true;
      setRotation(chamber2wall4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    chamber1base.render(f5);
    chamber1wall1.render(f5);
    chamber1wall2.render(f5);
    chamber1wall3.render(f5);
    chamber1wall4.render(f5);
    pipe1wall1.render(f5);
    pipe1wall2.render(f5);
    pipe1wall3.render(f5);
    pipe1wall4.render(f5);
    pipe1wall1part2.render(f5);
    thermometer.render(f5);
    pipe2wall1.render(f5);
    pipe2wall2.render(f5);
    pipe2wall3.render(f5);
    pipe2wall4.render(f5);
    condenser1.render(f5);
    condenser2.render(f5);
    condenser3.render(f5);
    condenser4.render(f5);
    chamber2base.render(f5);
    chamber2wall1.render(f5);
    chamber2wall2.render(f5);
    chamber2wall3.render(f5);
    chamber2wall4.render(f5);
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
