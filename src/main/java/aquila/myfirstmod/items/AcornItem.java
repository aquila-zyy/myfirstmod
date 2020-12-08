package aquila.myfirstmod.items;

import aquila.myfirstmod.itemgroup.ModGroups;
import aquila.myfirstmod.itemgroup.ModItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class AcornItem extends Item {

  private static final EffectInstance effectInstance =
      new EffectInstance(Effects.FIRE_RESISTANCE, 3 * 20, 0);
  private static final Food food = (new Food.Builder())
          .saturation(2)
          .hunger(2)
          .effect(() -> effectInstance, 1)
          .build();

  public AcornItem() {
    super(new Properties().food(food).group(ModGroups.modItemGroup));
  }
}
