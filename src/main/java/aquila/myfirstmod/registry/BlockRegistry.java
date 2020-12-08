package aquila.myfirstmod.registry;

import aquila.myfirstmod.blocks.FrostCoreBlock;
import aquila.myfirstmod.blocks.FrostHolocronBlock;
import aquila.myfirstmod.blocks.GlassBottleBlock;
import aquila.myfirstmod.blocks.PuzzleTorchBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {

  public static final DeferredRegister<Block> registrar =
      DeferredRegister.create(ForgeRegistries.BLOCKS, "myfirstmod");

  public static RegistryObject<Block> frostCoreBlock =
      registrar.register("frost_core_block", FrostCoreBlock::new);
  public static RegistryObject<Block> frostHolocronBlock =
      registrar.register("frost_holocron_block", FrostHolocronBlock::new);
  public static RegistryObject<Block> puzzleTorchBlock =
      registrar.register("puzzle_torch_block", PuzzleTorchBlock::new);
  public static RegistryObject<Block> glassBottleBlock =
      registrar.register("glass_bottle_block", GlassBottleBlock::new);

}
