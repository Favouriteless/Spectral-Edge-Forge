package com.favouriteless.spectraledge;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid=SpectralEdge.MOD_ID, bus=Bus.FORGE)
public class SpectralEdgeEvents {

	@SubscribeEvent
	public static void onLivingHurt(LivingHurtEvent event) {
		Entity att = event.getSource().getDirectEntity();
		if(att instanceof LivingEntity) {
			LivingEntity attacker = (LivingEntity)att;
			float multiplier = 1 + EnchantmentHelper.getEnchantmentLevel(SpectralEdge.SPECTRAL_EDGE.get(), attacker) * SpectralEdgeConfig.DAMAGE_PERCENT.get() / 100F;
			float amount = event.getAmount() * multiplier;
			event.setAmount(amount);
		}
	}

}
