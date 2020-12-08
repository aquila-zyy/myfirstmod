package aquila.myfirstmod.itemgroup;

import aquila.myfirstmod.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup extends ItemGroup {

    public ModItemGroup() {
        super("my_item_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.appleSword.get());
    }
}
