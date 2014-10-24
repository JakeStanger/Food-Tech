package roboguy99.foodTech.proxies;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import roboguy99.foodTech.client.render.block.RenderGrindstone;
import roboguy99.foodTech.client.render.block.RenderWindTurbine;
import roboguy99.foodTech.client.render.item.RenderItemWindTurbine;
import roboguy99.foodTech.common.item.CreateItems;
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
		
		//Render 3D item models
		MinecraftForgeClient.registerItemRenderer(CreateItems.itemWindTurbine, (IItemRenderer)new RenderItemWindTurbine());
	}
}
