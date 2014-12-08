package roboguy99.foodTech.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelOven - Roboguy99
 * Created using Tabula 4.0.2
 */
public class ModelOven extends ModelBase {
    public ModelRenderer Front_Window;
    public ModelRenderer Front_Right;
    public ModelRenderer Front_Left;
    public ModelRenderer Front_Top;
    public ModelRenderer Front_Bottom;
    public ModelRenderer Shelf_Top;
    public ModelRenderer Shelf_Bottom;
    public ModelRenderer Backplate;
    public ModelRenderer Right_Wall;
    public ModelRenderer Left_Wall;
    public ModelRenderer Bottom_Plate;
    public ModelRenderer Top_Plate;
    public ModelRenderer Knob2;
    public ModelRenderer Knob3;
    public ModelRenderer Knob4;
    public ModelRenderer Knob1;

    public ModelOven() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Front_Bottom = new ModelRenderer(this, 37, 54);
        this.Front_Bottom.setRotationPoint(-6.0F, 21.0F, -8.0F);
        this.Front_Bottom.addBox(0.0F, 0.0F, 0.0F, 12, 2, 1);
        this.Shelf_Top = new ModelRenderer(this, 0, 62);
        this.Shelf_Top.setRotationPoint(-7.0F, 14.0F, -6.0F);
        this.Shelf_Top.addBox(0.0F, 0.0F, 0.0F, 14, 1, 12);
        this.Knob1 = new ModelRenderer(this, 0, 90);
        this.Knob1.setRotationPoint(5.0F, 10.0F, -9.0F);
        this.Knob1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Knob4 = new ModelRenderer(this, 0, 99);
        this.Knob4.setRotationPoint(-4.0F, 10.0F, -9.0F);
        this.Knob4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Shelf_Bottom = new ModelRenderer(this, 0, 76);
        this.Shelf_Bottom.setRotationPoint(-7.0F, 20.0F, -6.0F);
        this.Shelf_Bottom.addBox(0.0F, 0.0F, 0.0F, 14, 1, 12);
        this.Front_Left = new ModelRenderer(this, 32, 49);
        this.Front_Left.setRotationPoint(-7.0F, 12.0F, -8.0F);
        this.Front_Left.addBox(0.0F, 0.0F, 0.0F, 1, 11, 1);
        this.Backplate = new ModelRenderer(this, 0, 0);
        this.Backplate.setRotationPoint(-8.0F, 8.0F, 7.0F);
        this.Backplate.addBox(0.0F, 0.0F, 0.0F, 16, 16, 1);
        this.Knob2 = new ModelRenderer(this, 0, 93);
        this.Knob2.setRotationPoint(3.0F, 10.0F, -9.0F);
        this.Knob2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Front_Right = new ModelRenderer(this, 27, 49);
        this.Front_Right.setRotationPoint(6.0F, 12.0F, -8.0F);
        this.Front_Right.addBox(0.0F, 0.0F, 0.0F, 1, 11, 1);
        this.Front_Top = new ModelRenderer(this, 37, 49);
        this.Front_Top.setRotationPoint(-7.0F, 9.0F, -8.0F);
        this.Front_Top.addBox(0.0F, 0.0F, 0.0F, 14, 3, 1);
        this.Bottom_Plate = new ModelRenderer(this, 0, 32);
        this.Bottom_Plate.setRotationPoint(-7.0F, 23.0F, -8.0F);
        this.Bottom_Plate.addBox(0.0F, 0.0F, 0.0F, 14, 1, 15);
        this.Left_Wall = new ModelRenderer(this, 68, 0);
        this.Left_Wall.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.Left_Wall.addBox(0.0F, 0.0F, 0.0F, 1, 16, 15);
        this.Front_Window = new ModelRenderer(this, 0, 49);
        this.Front_Window.setRotationPoint(-6.0F, 21.0F, -8.0F);
        this.Front_Window.addBox(0.0F, -9.0F, 0.0F, 12, 9, 1);
        this.Knob3 = new ModelRenderer(this, 0, 96);
        this.Knob3.setRotationPoint(-6.0F, 10.0F, -9.0F);
        this.Knob3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Right_Wall = new ModelRenderer(this, 35, 0);
        this.Right_Wall.setRotationPoint(7.0F, 8.0F, -8.0F);
        this.Right_Wall.addBox(0.0F, 0.0F, 0.0F, 1, 16, 15);
        this.Top_Plate = new ModelRenderer(this, 59, 32);
        this.Top_Plate.setRotationPoint(-7.0F, 8.0F, -8.0F);
        this.Top_Plate.addBox(0.0F, 0.0F, 0.0F, 14, 1, 15);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Front_Bottom.render(f5);
        this.Shelf_Top.render(f5);
        this.Knob1.render(f5);
        this.Knob4.render(f5);
        this.Shelf_Bottom.render(f5);
        this.Front_Left.render(f5);
        this.Backplate.render(f5);
        this.Knob2.render(f5);
        this.Front_Right.render(f5);
        this.Front_Top.render(f5);
        this.Bottom_Plate.render(f5);
        this.Left_Wall.render(f5);
        this.Front_Window.render(f5);
        this.Knob3.render(f5);
        this.Right_Wall.render(f5);
        this.Top_Plate.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
