package aquila.myfirstmod.registry;

import aquila.myfirstmod.itemgroup.ModGroups;
import aquila.myfirstmod.items.AcornItem;
import aquila.myfirstmod.items.AppleSwordItem;
import aquila.myfirstmod.items.FrostCoreItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

    public static final DeferredRegister<Item> registrar = DeferredRegister.create(ForgeRegistries.ITEMS, "myfirstmod");

    public static RegistryObject<Item> frostCore = registrar.register("frost_core", FrostCoreItem::new);
    public static RegistryObject<Item> acorn = registrar.register("acorn", AcornItem::new);
    public static RegistryObject<Item> appleSword = registrar.register("apple_sword", AppleSwordItem::new);


    public static RegistryObject<Item> frostCoreBlock = registrar.register("frost_core_block",
            () -> new BlockItem(BlockRegistry.frostCoreBlock.get(), new Item.Properties().group(ModGroups.modBlockGroup)));
    public static RegistryObject<Item> frostHolocronBlock = registrar.register("frost_holocron_block",
            () -> new BlockItem(BlockRegistry.frostHolocronBlock.get(), new Item.Properties().group(ModGroups.modBlockGroup)));
    public static RegistryObject<Item> puzzleTorchBlock = registrar.register("puzzle_torch_block",
            () -> new BlockItem(BlockRegistry.puzzleTorchBlock.get(), new Properties().group(ModGroups.modBlockGroup)));
    public static RegistryObject<Item> glassBottleBlock = registrar.register("glass_bottle_block",
            () -> new BlockItem(BlockRegistry.glassBottleBlock.get(), new Item.Properties().group(ModGroups.modBlockGroup)));

}
