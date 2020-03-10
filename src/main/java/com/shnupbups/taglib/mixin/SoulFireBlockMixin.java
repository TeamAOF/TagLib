package com.shnupbups.taglib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoulFireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import com.shnupbups.taglib.FunctionalTags;

@Mixin(SoulFireBlock.class)
public class SoulFireBlockMixin {
	@Inject(method = "canPlaceAt(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;)Z", at = @At("HEAD"), cancellable = true)
	public void canPlaceSoulFire(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		if(world.getBlockState(pos.down()).getBlock().isIn(FunctionalTags.SUPPORTS_SOUL_FIRE)) cir.setReturnValue(true);
	}
}
