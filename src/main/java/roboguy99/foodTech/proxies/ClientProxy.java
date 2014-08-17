package roboguy99.foodTech.proxies;

import roboguy99.foodTech.tileEntities.TileEntityCable;
import roboguy99.foodTech.tileEntities.TileEntityGrindstone;
import roboguy99.foodTech.tileEntities.TileEntityWindTurbine;
import roboguy99.foodTech.tileEntities.render.RenderCable;
import roboguy99.foodTech.tileEntities.render.RenderGrindstone;
import roboguy99.foodTech.tileEntities.render.RenderWindTurbine;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy //For client-side only events
{
	public void registerProxies() 
	{
		//Render custom tile entities
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindTurbine.class, new RenderWindTurbine());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindstone.class, new RenderGrindstone());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCable.class, new RenderCable());
	}
}
