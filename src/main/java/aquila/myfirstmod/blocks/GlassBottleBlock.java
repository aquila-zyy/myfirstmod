package aquila.myfirstmod.blocks;

import aquila.myfirstmod.registry.ItemRegistry;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class GlassBottleBlock extends Block {

  private static final VoxelShape shape;
  private static final VoxelShape inside;
  private static final VoxelShape withLid;

  private static final BooleanProperty capped = BooleanProperty.create("capped");

  static {
    inside =
        VoxelShapes.or(
            Block.makeCuboidShape(2, 1, 2, 14, 12, 14),
            Block.makeCuboidShape(3, 12, 3, 13, 14, 13));
    shape =
        VoxelShapes.combineAndSimplify(
            VoxelShapes.or(
                Block.makeCuboidShape(1, 0, 1, 15, 12, 15),
                Block.makeCuboidShape(2, 12, 2, 14, 14, 14)),
            inside,
            IBooleanFunction.ONLY_FIRST);
    withLid = VoxelShapes.or(shape, Block.makeCuboidShape(3, 12, 3, 13, 16, 13));
  }

  public GlassBottleBlock() {
    super(
        Properties.create(Material.GLASS)
            .hardnessAndResistance(0.3F)
            .sound(SoundType.GLASS)
            .harvestLevel(0)
            .harvestTool(ToolType.PICKAXE)
            .notSolid());
    setDefaultState(getStateContainer().getBaseState().with(capped, false));
  }

  @Override
  protected void fillStateContainer(Builder<Block, BlockState> builder) {
    builder.add(capped);
    super.fillStateContainer(builder);
  }

  @Override
  public List<ItemStack> getDrops(BlockState p_220076_1_, LootContext.Builder p_220076_2_) {
    List<ItemStack> list = new ArrayList<>();
    ItemStack drop = new ItemStack(() -> ItemRegistry.glassBottleBlock.get());
    list.add(drop);
    return list;
  }

  @Override
  public VoxelShape getRaytraceShape(
      BlockState p_199600_1_, IBlockReader p_199600_2_, BlockPos p_199600_3_) {
    return inside;
  }

  @Override
  public VoxelShape getShape(
      BlockState blockState, IBlockReader reader, BlockPos pos, ISelectionContext context) {
    return blockState.get(capped) ? withLid : shape;
  }
}
