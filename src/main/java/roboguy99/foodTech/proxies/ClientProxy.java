package roboguy99.foodTech.proxies;

import roboguy99.foodTech.client.render.RenderCable;
import roboguy99.foodTech.client.render.RenderGrindstone;
import roboguy99.foodTech.client.render.RenderWindTurbine;
import roboguy99.foodTech.common.tileEntities.TileEntityCable;
import roboguy99.foodTech.common.tileEntities.TileEntityGrindstone;
import roboguy99.foodTech.common.tileEntities.TileEntityWindTurbine;
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
