package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Registry;

import net.mcreator.gildeddoom.init.GildedDoomModItems;
import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;

import java.util.Map;
import java.util.HashMap;

public class DuckspawninpurgatoryProcedure {
	public DuckspawninpurgatoryProcedure() {
		ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, amount) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("entity", entity);
			dependencies.put("x", entity.getX());
			dependencies.put("y", entity.getY());
			dependencies.put("z", entity.getZ());
			dependencies.put("world", entity.level);
			dependencies.put("sourceentity", damageSource.getEntity());
			execute(dependencies);
			return true;
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure Duckspawninpurgatory!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Duckspawninpurgatory!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (entity instanceof Skeleton && (entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("gilded_doom:purgatory_dimension")))
				&& (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(GildedDoomModItems.PURGATORY_AMALGAM)) : false)) {
			{
				Entity _ent = sourceentity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("SkeletonSouls");
				if (_so == null)
					_so = _sc.addObjective("SkeletonSouls", ObjectiveCriteria.DUMMY, Component.literal("SkeletonSouls"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("SkeletonSouls", sourceentity) + 1));
			}
		}
		if (entity instanceof Blaze && (entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("gilded_doom:purgatory_dimension")))
				&& (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(GildedDoomModItems.PURGATORY_AMALGAM)) : false)) {
			{
				Entity _ent = sourceentity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("BlazeSouls");
				if (_so == null)
					_so = _sc.addObjective("BlazeSouls", ObjectiveCriteria.DUMMY, Component.literal("BlazeSouls"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("BlazeSouls", sourceentity) + 1));
			}
		}
		if (entity instanceof Piglin && (entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("gilded_doom:purgatory_dimension")))
				&& (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(GildedDoomModItems.PURGATORY_AMALGAM)) : false)) {
			{
				Entity _ent = sourceentity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("PiglinSouls");
				if (_so == null)
					_so = _sc.addObjective("PiglinSouls", ObjectiveCriteria.DUMMY, Component.literal("PiglinSouls"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("PiglinSouls", sourceentity) + 1));
			}
		}
	}
}
