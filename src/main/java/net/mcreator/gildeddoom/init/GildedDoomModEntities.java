
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gildeddoom.init;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.gildeddoom.entity.SavageDuckEntity;
import net.mcreator.gildeddoom.entity.DuckEntity;
import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class GildedDoomModEntities {
	public static EntityType<DuckEntity> DUCK;
	public static EntityType<SavageDuckEntity> SAVAGE_DUCK;

	public static void load() {
		DUCK = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(GildedDoomMod.MODID, "duck"),
				FabricEntityTypeBuilder.create(MobCategory.CREATURE, DuckEntity::new).dimensions(new EntityDimensions(0.4f, 0.7f, true)).fireImmune().trackRangeBlocks(64).forceTrackedVelocityUpdates(true).trackedUpdateRate(3).build());
		DuckEntity.init();
		FabricDefaultAttributeRegistry.register(DUCK, DuckEntity.createAttributes());
		SAVAGE_DUCK = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(GildedDoomMod.MODID, "savage_duck"),
				FabricEntityTypeBuilder.create(MobCategory.MONSTER, SavageDuckEntity::new).dimensions(new EntityDimensions(0.4f, 0.7f, true)).fireImmune().trackRangeBlocks(64).forceTrackedVelocityUpdates(true).trackedUpdateRate(3).build());
		SavageDuckEntity.init();
		FabricDefaultAttributeRegistry.register(SAVAGE_DUCK, SavageDuckEntity.createAttributes());
	}

	private static <T extends Entity> EntityType<T> createArrowEntityType(EntityType.EntityFactory<T> factory) {
		return FabricEntityTypeBuilder.create(MobCategory.MISC, factory).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(1).trackedUpdateRate(64).build();
	}
}
