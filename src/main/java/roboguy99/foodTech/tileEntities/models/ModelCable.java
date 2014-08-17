package roboguy99.foodTech.tileEntities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCable extends ModelBase
{
  //fields
    ModelRenderer Up;
    ModelRenderer South;
    ModelRenderer Core;
    ModelRenderer North;
    ModelRenderer Down;
    ModelRenderer East;
    ModelRenderer West;
    
    private boolean upConnected = false; 
    private boolean downConnected = false; 
    private boolean northConnected = false; 
    private boolean southConnected = false; 
    private boolean eastConnected = false; 
    private boolean westConnected = false;
  
	public ModelCable(boolean[] neighbourBlockWires)
	{
		this.upConnected = neighbourBlockWires[0];
		this.downConnected = neighbourBlockWires[1];
		this.northConnected = neighbourBlockWires[2];
		this.southConnected = neighbourBlockWires[3];
		this.eastConnected = neighbourBlockWires[4];
		this.westConnected = neighbourBlockWires[5];
		
		textureWidth = 128;
	    textureHeight = 32;
	    
	    Core = new ModelRenderer(this, 0, 0);
	    Core.addBox(0F, 0F, 0F, 4, 4, 4);
	    Core.setRotationPoint(-2F, 14F, -2F);
	    Core.setTextureSize(128, 32);
	    Core.mirror = true;
	    setRotation(Core, 0F, 0F, 0F);
	    
	    if (downConnected)
	    {
		    Up = new ModelRenderer(this, 20, 0);
		    Up.addBox(0F, 0F, 0F, 4, 6, 4);
		    Up.setRotationPoint(-2F, 8F, -2F);
		    Up.setTextureSize(128, 32);
		    Up.mirror = true;
		    setRotation(Up, 0F, 0F, 0F);
	    }
	    
		if (upConnected)
		{
	    	Down = new ModelRenderer(this, 20, 20);
		    Down.addBox(0F, 0F, 0F, 4, 6, 4);
		    Down.setRotationPoint(-2F, 18F, -2F);
		    Down.setTextureSize(128, 32);
		    Down.mirror = true;
		    setRotation(Down, 0F, 0F, 0F);
		}
	
	    if (southConnected)
	    {
			North = new ModelRenderer(this, 50, 0);
		    North.addBox(0F, 0F, 0F, 4, 4, 6);
		    North.setRotationPoint(-2F, 14F, -8F);
		    North.setTextureSize(128, 32);
		    North.mirror = true;
		    setRotation(North, 0F, 0F, 0F);
	    }
	    
		if (northConnected)
		{
	    	South = new ModelRenderer(this, 72, 0);
		    South.addBox(0F, 0F, 0F, 4, 4, 6);
		    South.setRotationPoint(-2F, 14F, 2F);
		    South.setTextureSize(128, 32);
		    South.mirror = true;
		    setRotation(South, 0F, 0F, 0F);
		}
	    
		if (westConnected)
		{
		    East = new ModelRenderer(this, 0, 11);
		    East.addBox(0F, 0F, 0F, 6, 4, 4);
		    East.setRotationPoint(-8F, 14F, -2F);
		    East.setTextureSize(128, 32);
		    East.mirror = true;
		    setRotation(East, 0F, 0F, 0F);
		}
	    
		if (eastConnected)
		{
		    West = new ModelRenderer(this, 23, 11);
		    West.addBox(0F, 0F, 0F, 6, 4, 4);
		    West.setRotationPoint(2F, 14F, -2F);
		    West.setTextureSize(128, 32);
		    West.mirror = true;
		    setRotation(West, 0F, 0F, 0F);
		}
	}
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Core.render(f5);
	    
	    if (downConnected) Up.render(f5);
	    if (upConnected) Down.render(f5);
	    if (southConnected) North.render(f5);
	    if (northConnected) South.render(f5);
	    if (westConnected) East.render(f5);
	    if (eastConnected) West.render(f5);
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
