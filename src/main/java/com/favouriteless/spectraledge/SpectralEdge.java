package com.favouriteless.spectraledge;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(SpectralEdge.MOD_ID)
public class SpectralEdge
{
    public static final String MOD_ID = "spectraledge";
    public static final DeferredRegister<Enchantment> ENCHANTMENT_REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MOD_ID);
    public static final RegistryObject<Enchantment> SPECTRAL_EDGE = ENCHANTMENT_REGISTRY.register("spectral_edge", SpectralEdgeEnchantment::new);

    public SpectralEdge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SpectralEdgeConfig.SPEC, "spectral_edge-common.toml");
        ENCHANTMENT_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
