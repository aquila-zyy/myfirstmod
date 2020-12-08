package aquila.myfirstmod.itemgroup;

import aquila.myfirstmod.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModBlockGroup extends ItemGroup {

    public ModBlockGroup() {
        super("my_block_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.acorn.get());
    }
}
