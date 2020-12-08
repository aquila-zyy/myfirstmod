package aquila.myfirstmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;

public class FrostHolocronBlock extends Block {

  private static final BooleanProperty LIT = BlockStateProperties.LIT;

  public FrostHolocronBlock() {
    super(
        Properties.create(Material.GLASS)
            .harvestLevel(3)
            .setRequiresTool()
            .harvestTool(ToolType.PICKAXE)
            .setLightLevel((blockState) -> (Boolean) blockState.get(LIT) ? 12 : 0)
            .hardnessAndResistance(50F, 1200F));
    setDefaultState(getStateContainer().getBaseState().with(LIT, false));
  }

  @Override
  protected void fillStateContainer(Builder<Block, BlockState> builder) {
    builder.add(LIT);
    super.fillStateContainer(builder);
  }
}
