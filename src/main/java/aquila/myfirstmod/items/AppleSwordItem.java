package aquila.myfirstmod.items;

import aquila.myfirstmod.itemgroup.ModGroups;
import aquila.myfirstmod.items.itemtiers.ItemTierFood;
import net.minecraft.item.Food;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

public class AppleSwordItem extends SwordItem {

    private static IItemTier iItemTier = new ItemTierFood();
    private static Food food = new Food.Builder().saturation(10).hunger(10).build();

    public AppleSwordItem() {
        super(iItemTier, 1, -2.4f, new Item.Properties().food(food).group(ModGroups.modItemGroup));
    }
}
