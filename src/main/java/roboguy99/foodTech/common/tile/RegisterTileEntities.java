package roboguy99.foodTech.common.tile;

import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.common.tile.generators.TileWindTurbine;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntities //Registers custom tile entities into the game
{
	public RegisterTileEntities()
	{
		FoodTech.print("Loading custom tile entities");
		
		GameRegistry.registerTileEntity(TileWindTurbine.class, "r99_windTurbine");
		GameRegistry.registerTileEntity(TileGrindstone.class, "r99_grindstone");
		GameRegistry.registerTileEntity(TileWire.class, "r99_cable");
	}
}
