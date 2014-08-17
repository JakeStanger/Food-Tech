package roboguy99.foodTech.tileEntities;

import roboguy99.foodTech.Main;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntities //Registers custom tile entities into the game
{
	public RegisterTileEntities()
	{
		Main.print("Loading custom tile entities");
		
		GameRegistry.registerTileEntity(TileEntityWindTurbine.class, "r99_windTurbine");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, "r99_grindstone");
		GameRegistry.registerTileEntity(TileEntityCable.class, "r99_cable");
	}
}
