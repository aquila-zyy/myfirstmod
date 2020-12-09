package aquila.myfirstmod.blocks;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
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

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    state = state.with(LIT, !state.get(LIT));
    worldIn.setBlockState(pos, state, 2);
    playSound(player, worldIn, pos, state.get(LIT));
    return ActionResultType.func_233537_a_(worldIn.isRemote);
  }

  protected void playSound(
      @Nullable PlayerEntity player, World worldIn, BlockPos pos, boolean isLit) {
    worldIn.playSound(
        null,
        pos,
        isLit ? SoundEvents.BLOCK_BEACON_ACTIVATE : SoundEvents.BLOCK_BEACON_DEACTIVATE,
        SoundCategory.BLOCKS,
        1F,
        1f);
  }
}
