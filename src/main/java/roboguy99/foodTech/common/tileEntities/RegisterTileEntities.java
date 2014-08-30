package roboguy99.foodTech.common.tileEntities;

import roboguy99.foodTech.FoodTech;
import roboguy99.foodTech.common.tileEntities.generators.TileWindTurbine;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntities //Registers custom tile entities into the game
{
	public RegisterTileEntities()
	{
		FoodTech.print("Loading custom tile entities");
		
		GameRegistry.registerTileEntity(TileWindTurbine.class, "r99_windTurbine");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, "r99_grindstone");
		GameRegistry.registerTileEntity(TileEntityCable.class, "r99_cable");
	}
}
