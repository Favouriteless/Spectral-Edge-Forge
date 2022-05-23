package com.favouriteless.spectraledge;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class SpectralEdgeEnchantment extends Enchantment {

	protected SpectralEdgeEnchantment() {
		super(Rarity.COMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
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

			if(attacker instanceof Player){
				livingTarget.hurt(DamageSource.playerAttack((Player)attacker), bonusDamage);
			}
			else {
				livingTarget.hurt(DamageSource.mobAttack(attacker), bonusDamage);
			}
		}
	}

}
