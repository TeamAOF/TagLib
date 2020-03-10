package com.shnupbups.taglib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import com.shnupbups.taglib.FireBlockAccessor;
import com.shnupbups.taglib.FunctionalTags;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
	@Inject(method = "getState(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;", at = @At("HEAD"), cancellable = true)
	private static void getState(BlockView world, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
		BlockPos blockPos = pos.down();
		BlockState blockState = world.getBlockState(blockPos);
		cir.setReturnValue(blockState.getBlock().isIn(FunctionalTags.SUPPORTS_SOUL_FIRE) ? Blocks.SOUL_FIRE.getDefaultState() : ((FireBlockAccessor)Blocks.FIRE).getStateForPositionAccessor(world, pos));
	}
}
