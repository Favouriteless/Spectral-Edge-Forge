package com.favouriteless.spectraledge;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;

public class SpectralEdgeEnchantment extends Enchantment {

	protected SpectralEdgeEnchantment(EquipmentSlotType... slots) {
		super(Rarity.COMMON, EnchantmentType.WEAPON, slots);
	}

	@Override
	public int getMinCost(int pEnchantmentLevel) {
		return 1 + (pEnchantmentLevel - 1) * SpectralEdgeConfig.LEVEL_COST.get();
	}

	@Override
	public int getMaxCost(int pEnchantmentLevel) {
		return this.getMinCost(pEnchantmentLevel) + SpectralEdgeConfig.LEVEL_COST.get();
	}

	@Override
	public int getMaxLevel() {
		return SpectralEdgeConfig.MAX_LEVEL.get();
	}

	@Override
	public boolean checkCompatibility(Enchantment enchantment) {
		return !(enchantment instanceof DamageEnchantment);
	}

	@Override
	public boolean canEnchant(ItemStack pStack) {
		return pStack.getItem() instanceof AxeItem || super.canEnchant(pStack);
	}

	@Override
	public void doPostAttack(LivingEntity attacker, Entity target, int pLevel) {
		if (target instanceof LivingEntity) {
			LivingEntity livingTarget = (LivingEntity)target;
			float damageMultiplier = SpectralEdgeConfig.DAMAGE_PERCENT.get() * EnchantmentHelper.getEnchantmentLevel(SpectralEdge.SPECTRAL_EDGE.get(), attacker);
			float bonusDamage = (float)livingTarget.getAttribute(Attributes.ATTACK_DAMAGE).getValue() * damageMultiplier;

			if(attacker instanceof PlayerEntity){
				livingTarget.hurt(DamageSource.playerAttack((PlayerEntity)attacker), bonusDamage);
			}
			else {
				livingTarget.hurt(DamageSource.mobAttack(attacker), bonusDamage);
			}
		}
	}

}
