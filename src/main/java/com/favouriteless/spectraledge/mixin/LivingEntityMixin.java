package com.favouriteless.spectraledge.mixin;

import com.favouriteless.spectraledge.SpectralEdge;
import com.favouriteless.spectraledge.SpectralEdgeConfig;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Inject(method="getAttributeValue", at=@At("RETURN"), cancellable = true)
	public void getAttributeValue(Attribute attribute, CallbackInfoReturnable<Double> cir) {
		if(attribute == Attributes.ATTACK_DAMAGE) {
			cir.setReturnValue(((LivingEntity)(Object)this).getAttributes().getValue(attribute) *
					(1 + EnchantmentHelper.getItemEnchantmentLevel(SpectralEdge.SPECTRAL_EDGE.get(), ((LivingEntity)(Object)this).getMainHandItem())
							* SpectralEdgeConfig.DAMAGE_PERCENT.get()/100F));
		}
	}

}
