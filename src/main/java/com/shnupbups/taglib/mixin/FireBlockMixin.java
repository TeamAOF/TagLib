package com.shnupbups.taglib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.block.FireBlock;

@Mixin(FireBlock.class)
public abstract class FireBlockMixin {
	@ModifyVariable(method = "onScheduledTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)V", ordinal = 0, at =
	@At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;"))
	private boolean handleInfiniteFlammables(boolean prevBool) {
		return prevBool;
	}
}