
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gildeddoom.init;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

import net.mcreator.gildeddoom.world.features.ores.IronInfusedPurgatoryStoneFeature;
import net.mcreator.gildeddoom.world.features.ores.GildedPurgatoryStoneFeature;
import net.mcreator.gildeddoom.world.features.ores.DemenaniteOreFeature;
import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;

import java.util.function.Predicate;

public class GildedDoomModFeatures {
	public static void load() {
		register("gilded_purgatory_stone", GildedPurgatoryStoneFeature.feature(), GildedPurgatoryStoneFeature.GENERATE_BIOMES, GenerationStep.Decoration.UNDERGROUND_ORES);
		register("iron_infused_purgatory_stone", IronInfusedPurgatoryStoneFeature.feature(), IronInfusedPurgatoryStoneFeature.GENERATE_BIOMES, GenerationStep.Decoration.UNDERGROUND_ORES);
		register("demenanite_ore", DemenaniteOreFeature.feature(), DemenaniteOreFeature.GENERATE_BIOMES, GenerationStep.Decoration.UNDERGROUND_ORES);
	}

	private static void register(String registryName, Feature feature, Predicate<BiomeSelectionContext> biomes, GenerationStep.Decoration genStep) {
		Registry.register(Registry.FEATURE, new ResourceLocation(GildedDoomMod.MODID, registryName), feature);
		BiomeModifications.addFeature(biomes, genStep, ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(GildedDoomMod.MODID, registryName)));
	}
}
