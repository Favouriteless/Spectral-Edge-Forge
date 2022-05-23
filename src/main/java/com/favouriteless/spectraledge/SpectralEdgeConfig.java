package com.favouriteless.spectraledge;

import net.minecraftforge.common.ForgeConfigSpec;
public class SpectralEdgeConfig {

	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Integer> LEVEL_COST;
	public static final ForgeConfigSpec.ConfigValue<Integer> MAX_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Float> DAMAGE_PERCENT;

	static {
		LEVEL_COST = BUILDER.define("cost_per_level", 11);
		MAX_LEVEL = BUILDER.define("max_levels", 5);
		DAMAGE_PERCENT = BUILDER.comment("Bonus damage added per level as %").define("bonus_damage_per_level", 20F);
		SPEC = BUILDER.build();
	}

}
