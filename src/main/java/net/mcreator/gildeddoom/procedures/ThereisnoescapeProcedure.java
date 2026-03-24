package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Registry;

import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;

import java.util.Map;
import java.util.HashMap;

public class ThereisnoescapeProcedure {
	public ThereisnoescapeProcedure() {
		ServerEntityWorldChangeEvents.AFTER_ENTITY_CHANGE_WORLD.register((originalEntity, newEntity, origin, destination) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", newEntity.getX());
			dependencies.put("y", newEntity.getY());
			dependencies.put("z", newEntity.getZ());
			dependencies.put("world", destination);
			dependencies.put("entity", newEntity);
			dependencies.put("dimension", destination.dimension());
			if (!(newEntity instanceof Player))
				execute(dependencies);
		});
		ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((player, origin, destination) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", player.getX());
			dependencies.put("y", player.getY());
			dependencies.put("z", player.getZ());
			dependencies.put("world", destination);
			dependencies.put("entity", player);
			dependencies.put("dimension", destination.dimension());
			execute(dependencies);
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure Thereisnoescape!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure Thereisnoescape!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("purgatory", entity) == 1 && !((ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("gilded_doom:purgatory_dimension"))) == (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD))) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A74<???> Oh no you dont."), false);
			PurgatoryAmalgamRightclickedProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("entity", entity).build());
		}
		if ((ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("gilded_doom:purgatory_dimension"))) == (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD)) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("purgatory");
				if (_so == null)
					_so = _sc.addObjective("purgatory", ObjectiveCriteria.DUMMY, Component.literal("purgatory"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
			}
		}
	}
}
