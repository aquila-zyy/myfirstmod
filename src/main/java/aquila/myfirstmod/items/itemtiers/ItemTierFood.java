package aquila.myfirstmod.items.itemtiers;

import aquila.myfirstmod.registry.ItemRegistry;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public class ItemTierFood implements IItemTier {

  private final LazyValue<Ingredient> repairMaterial =
      new LazyValue<>(
          () ->
              Ingredient.fromItems(
                  Items.APPLE, Items.BEETROOT, Items.SWEET_BERRIES, ItemRegistry.acorn.get()));

  @Override
  public int getMaxUses() {
    return 256;
  }

  @Override
  public float getEfficiency() {
    return 5f;
  }

  @Override
  public float getAttackDamage() {
    return 1.8f;
  }

  @Override
  public int getHarvestLevel() {
    return 2;
  }

  @Override
  public int getEnchantability() {
    return 5;
  }

  @Override
  public Ingredient getRepairMaterial() {
    return this.repairMaterial.getValue();
  }
}
