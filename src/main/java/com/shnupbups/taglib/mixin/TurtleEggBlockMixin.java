package com.shnupbups.taglib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoulFireBlock;
import net.minecraft.block.TurtleEggBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

import com.shnupbups.taglib.FunctionalTags;

@Mixin(TurtleEggBlock.class)
public class TurtleEggBlockMixin {
	@Inject(method = "isSand(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z", at = @At("HEAD"), cancellable = true)
	public void canBlockSupport(BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		if(world.getBlockState(pos.down()).getBlock().isIn(FunctionalTags.SUPPORTS_TURTLE_EGGS)) cir.setReturnValue(true);
	}
}
