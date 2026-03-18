package net.mcreator.gildeddoom.procedures;

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

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

import java.util.Map;
import java.util.HashMap;

public class NopeNotHappeningProcedure {
	public NopeNotHappeningProcedure() {
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("entity", handler.getPlayer());
			dependencies.put("x", handler.getPlayer().getX());
			dependencies.put("y", handler.getPlayer().getY());
			dependencies.put("z", handler.getPlayer().getZ());
			dependencies.put("world", handler.getPlayer().getLevel());
			execute(dependencies);
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure NopeNotHappening!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure NopeNotHappening!");
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
				_player.displayClientMessage(Component.literal("Oh no you dont."), false);
			PurgatoryAmalgamRightclickedProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("entity", entity).build());
		}
	}
}
