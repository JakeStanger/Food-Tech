package roboguy99.foodTech;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class GrindstoneRecipes
{
	private static final GrindstoneRecipes instance = new GrindstoneRecipes();
	private Map<Item, ItemStack> recipeList = new HashMap<Item, ItemStack>();
	private Map<Item, Float> experienceList = new HashMap<Item, Float>();
	
	public static GrindstoneRecipes smelting()
    {
        return GrindstoneRecipes.instance;
    }
	
	public GrindstoneRecipes()
	{
		this.addItemRecipe(Items.wheat, new ItemStack(roboguy99.foodTech.common.item.Items.itemFlour), 0.1F);
	}
	
	public void addBlockRecipe(Block input, ItemStack output, float xp)
	{
		this.addItemRecipe(Item.getItemFromBlock(input), output, xp);
	}
	
	public void addItemRecipe(Item input, ItemStack output, float xp)
	{
		this.addRecipeToList(input, output, xp);
	}
	
	public void addRecipeToList(Item input, ItemStack output, float xp)
	{
		this.recipeList.put(input, output);
		this.experienceList.put(input, xp);
	}
	
	public ItemStack getProcessResult(ItemStack itemStack)
    {
        Iterator<?> iterator = this.recipeList.entrySet().iterator();
        Entry<?, ?> entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry<?, ?>)iterator.next();
        }
        while (!this.checkItem(itemStack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }
	
	public float getProcessXPResult(ItemStack itemStack_)
    {
        float ret = itemStack_.getItem().getSmeltingExperience(itemStack_);
        if (ret != -1) return ret;

        Iterator<Entry<Item, Float>> iterator = this.experienceList.entrySet().iterator();
        Entry<?, ?> entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry<?, ?>)iterator.next();
        }
        while (!this.checkItem(itemStack_, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
	
	private boolean checkItem(ItemStack input, ItemStack output)
    {
        return output.getItem() == input.getItem() && (output.getItemDamage() == 32767 || output.getItemDamage() == input.getItemDamage());
    }
	
	public Map<Item, ItemStack> getRecipeList()
	{
		return this.recipeList;
	}

}
