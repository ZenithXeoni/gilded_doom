package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.gildeddoom.init.GildedDoomModMobEffects;
import net.mcreator.gildeddoom.init.GildedDoomModGameRules;
import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

import java.util.Map;
import java.util.HashMap;

public class UltimatePowerOnEffectActiveTickProcedure {
	public UltimatePowerOnEffectActiveTickProcedure() {
		ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", newPlayer.getX());
			dependencies.put("y", newPlayer.getY());
			dependencies.put("z", newPlayer.getZ());
			dependencies.put("world", newPlayer.level);
			dependencies.put("entity", newPlayer);
			dependencies.put("oldEntity", oldPlayer);
			execute(dependencies);
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure UltimatePowerOnEffectActiveTick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure UltimatePowerOnEffectActiveTick!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (world.getLevelData().getGameRules().getBoolean(GildedDoomModGameRules.ALLOWGILDEDBANISHMENT) && new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("user_has_ultimate_power", entity) == 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(GildedDoomModMobEffects.ULTIMATE_POWER, 60, 0, true, false));
		}
	}
}
