package com.favouriteless.spectraledge.mixin;

import com.favouriteless.spectraledge.SpectralEdge;
import com.favouriteless.spectraledge.SpectralEdgeConfig;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
public class ItemStackMixin {

	@ModifyVariable(method="getTooltipLines", at=@At(value="INVOKE", target="Lnet/minecraft/enchantment/EnchantmentHelper;getDamageBonus(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/CreatureAttribute;)F", shift=Shift.BY, by=4))
	private double getTooltipModifyDamage(double d) {
		return d * (1.0D + (EnchantmentHelper.getItemEnchantmentLevel(SpectralEdge.SPECTRAL_EDGE.get(), ((ItemStack)(Object)this)) * SpectralEdgeConfig.DAMAGE_PERCENT.get() / 100D));
	}

}
