package roboguy99.foodTech.proxies;

import roboguy99.foodTech.client.render.RenderGrindstone;
import roboguy99.foodTech.client.render.RenderWindTurbine;
import roboguy99.foodTech.common.tile.TileGrindstone;
import roboguy99.foodTech.common.tile.electricity.generator.TileWindTurbine;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy //For client-side only events
{
	public void registerProxies() 
	{
		//Render custom tile entities
		ClientRegistry.bindTileEntitySpecialRenderer(TileWindTurbine.class, new RenderWindTurbine());
		ClientRegistry.bindTileEntitySpecialRenderer(TileGrindstone.class, new RenderGrindstone());
	}
}
