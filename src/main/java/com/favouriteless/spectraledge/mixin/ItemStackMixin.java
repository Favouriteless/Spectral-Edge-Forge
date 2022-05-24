package com.favouriteless.spectraledge.mixin;

import com.favouriteless.spectraledge.SpectralEdge;
import com.favouriteless.spectraledge.SpectralEdgeConfig;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
public class ItemStackMixin {

	@ModifyVariable(method="getTooltipLines", at=@At(value="INVOKE", target="Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getDamageBonus(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/MobType;)F", shift=Shift.BY, by=4))
	private double getTooltipModifyDamage(double d) {
		return d * (1.0D + (EnchantmentHelper.getItemEnchantmentLevel(SpectralEdge.SPECTRAL_EDGE.get(), ((ItemStack)(Object)this)) * SpectralEdgeConfig.DAMAGE_PERCENT.get() / 100D));
	}

}
