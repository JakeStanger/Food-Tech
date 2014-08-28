package roboguy99.foodTech;

import roboguy99.foodTech.common.items.CreateItems;
import net.minecraft.stats.Achievement;


public class CreateAchievements 
{	static final Achievement makingBread = new Achievement("Thing1", "Thing2", 0, 0, CreateItems.itemWindTurbine, null);
	
	public CreateAchievements()
	{	
		FoodTech.print("Achivements created");
	}
}
