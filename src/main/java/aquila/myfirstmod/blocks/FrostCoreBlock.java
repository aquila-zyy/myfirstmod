package aquila.myfirstmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class FrostCoreBlock extends Block {

  public FrostCoreBlock() {
    super(
        Properties.create(Material.PACKED_ICE)
            .hardnessAndResistance(5.0F, 6.0F)
            .setRequiresTool()
            .sound(SoundType.GILDED_BLACKSTONE));
  }
}
