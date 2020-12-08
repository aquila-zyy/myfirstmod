package aquila.myfirstmod.items;

import aquila.myfirstmod.itemgroup.ModGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class FrostCoreItem extends Item {

  public FrostCoreItem() {
    super(new Properties().group(ModGroups.modItemGroup));
  }
}
