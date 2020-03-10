package com.shnupbups.taglib;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public interface FireBlockAccessor {
	public BlockState getStateForPositionAccessor(BlockView world, BlockPos pos);
}
