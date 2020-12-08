package aquila.myfirstmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class PuzzleTorchBlock extends Block {

  private static VoxelShape shape;

  static {
    VoxelShape base = Block.makeCuboidShape(7, 0, 7, 9, 8, 9);
    VoxelShape top = Block.makeCuboidShape(7, 12, 7, 9, 13, 9);
    shape = VoxelShapes.or(base, top);
  }

  public PuzzleTorchBlock() {
    super(
        Properties.create(Material.IRON)
            .hardnessAndResistance(50F, 1200F)
            .harvestTool(ToolType.PICKAXE)
            .notSolid());
  }

  @Override
  public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
    return shape;
  }
}
