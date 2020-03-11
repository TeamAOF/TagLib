package com.shnupbups.taglib.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import com.shnupbups.taglib.FunctionalTags;

@Mixin(Item.class)
public abstract class ItemMixin {
	@Shadow public abstract boolean isFireproof();
	
	@Inject(method = "isFireproof()Z", at = @At("HEAD"), cancellable = true)
	public void isInFireproofTag(CallbackInfoReturnable<Boolean> cir) {
		if(((Item)(Object)this).isIn(FunctionalTags.FIREPROOF)) cir.setReturnValue(true);
	}
	
	@Inject(method = "damage(Lnet/minecraft/entity/damage/DamageSource;)Z", at = @At("HEAD"), cancellable = true)
	public void damageEntity(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(!this.isFireproof() || !source.isFire());
	}
}
