package com.favouriteless.spectraledge;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

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

}
