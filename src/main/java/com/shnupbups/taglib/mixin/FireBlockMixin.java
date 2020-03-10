package com.shnupbups.taglib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import com.shnupbups.taglib.FireBlockAccessor;
import com.shnupbups.taglib.FunctionalTags;

import java.util.Random;

@Mixin(FireBlock.class)
public abstract class FireBlockMixin implements FireBlockAccessor {
	@Shadow protected abstract BlockState getStateForPosition(BlockView world, BlockPos pos);
	
	@ModifyVariable(method = "scheduledTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)V", ordinal = 0, at =
	@At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;"))
	private boolean handleInfiniteFlammables(boolean prevBool, BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if(world.getBlockState(pos.down()).getBlock().isIn(FunctionalTags.ETERNALLY_FLAMMABLE)) {
			return true;
		}
		return prevBool;
	}
	
	@Override
	public BlockState getStateForPositionAccessor(BlockView world, BlockPos pos) {
		return getStateForPosition(world, pos);
	}
}
