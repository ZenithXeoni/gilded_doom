package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.gildeddoom.init.GildedDoomModMobEffects;
import net.mcreator.gildeddoom.GildedDoomMod;

import java.util.Map;

public class GildedImmunityOnEffectActiveTickProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure GildedImmunityOnEffectActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(GildedDoomModMobEffects.DEATHS_MARK);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(GildedDoomModMobEffects.GILDED_STASIS);
	}
}
