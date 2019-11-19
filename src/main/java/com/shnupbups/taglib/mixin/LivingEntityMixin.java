package com.shnupbups.taglib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;

import com.shnupbups.taglib.FunctionalTags;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
	@Inject(method = "isClimbing", at = @At("RETURN"), cancellable = true)
	public void isClimbing(CallbackInfoReturnable<Boolean> info) {
		BlockState inState = this.method_16212();
		Block inBlock = inState.getBlock();
		if (inBlock.matches(FunctionalTags.CLIMBABLE)) info.setReturnValue(true);
	}
	
	@Shadow
	protected abstract BlockState method_16212();
}
