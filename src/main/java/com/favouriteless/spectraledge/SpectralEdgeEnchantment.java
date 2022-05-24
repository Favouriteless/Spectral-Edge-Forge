package com.favouriteless.spectraledge;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

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

}
