package com.favouriteless.spectraledge;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Mod(SpectralEdge.MOD_ID)
public class SpectralEdge
{
    public static final String MOD_ID = "spectraledge";
    public static final DeferredRegister<Enchantment> ENCHANTMENT_REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MOD_ID);
    public static final RegistryObject<Enchantment> SPECTRAL_EDGE = ENCHANTMENT_REGISTRY.register("spectral_edge", () -> new SpectralEdgeEnchantment(EquipmentSlotType.MAINHAND));

    public SpectralEdge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SpectralEdgeConfig.SPEC, "spectral_edge-common.toml");
        ENCHANTMENT_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
