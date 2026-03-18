package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.gildeddoom.init.GildedDoomModMobEffects;
import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.Map;
import java.util.Iterator;

public class NeptuniteOnlyProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure NeptuniteOnly!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency x for procedure NeptuniteOnly!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency y for procedure NeptuniteOnly!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency z for procedure NeptuniteOnly!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure NeptuniteOnly!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency itemstack for procedure NeptuniteOnly!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("purgatorytracker", entity) >= 2) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
			if (entity.isShiftKeyDown()) {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.getLevel().getScoreboard();
					Objective _so = _sc.getObjective("warpx");
					if (_so == null)
						_so = _sc.addObjective("warpx", ObjectiveCriteria.DUMMY, Component.literal("warpx"), ObjectiveCriteria.RenderType.INTEGER);
					_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) x);
				}
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.getLevel().getScoreboard();
					Objective _so = _sc.getObjective("warpy");
					if (_so == null)
						_so = _sc.addObjective("warpy", ObjectiveCriteria.DUMMY, Component.literal("warpy"), ObjectiveCriteria.RenderType.INTEGER);
					_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) y);
				}
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.getLevel().getScoreboard();
					Objective _so = _sc.getObjective("warpz");
					if (_so == null)
						_so = _sc.addObjective("warpz", ObjectiveCriteria.DUMMY, Component.literal("warpz"), ObjectiveCriteria.RenderType.INTEGER);
					_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) z);
				}
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("Purgatory Return Location Set"), true);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 15, 2, 3, 2, 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), SoundEvents.BEACON_POWER_SELECT, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.BEACON_POWER_SELECT, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), SoundEvents.PORTAL_TRIGGER, SoundSource.NEUTRAL, 1, (float) 1.25);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.PORTAL_TRIGGER, SoundSource.NEUTRAL, 1, (float) 1.25, false);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(GildedDoomModMobEffects.GILDED_STASIS, 80, 0));
				new Object() {
					private int ticks = 0;

					public void startDelay(LevelAccessor world) {
						ServerTickEvents.END_SERVER_TICK.register((server) -> {
							this.ticks++;
							if (this.ticks == 80) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(x, y, z), SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, SoundSource.NEUTRAL, 1, 2);
									} else {
										_level.playLocalSound(x, y, z, SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, SoundSource.NEUTRAL, 1, 2, false);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(x, y, z), SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, SoundSource.NEUTRAL, 1, 2);
									} else {
										_level.playLocalSound(x, y, z, SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, SoundSource.NEUTRAL, 1, 2, false);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(x, y, z), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 15, 2, 3, 2, 0);
								if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("gilded_doom:purgatory_dimension")))) {
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.getLevel().getScoreboard();
										Objective _so = _sc.getObjective("purgatory");
										if (_so == null)
											_so = _sc.addObjective("purgatory", ObjectiveCriteria.DUMMY, Component.literal("purgatory"), ObjectiveCriteria.RenderType.INTEGER);
										_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(2);
									}
									{
										Entity _ent = entity;
										if (!_ent.level.isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
													("/execute in minecraft:overworld run tp @s " + (new Object() {
														public int getScore(String score, Entity _ent) {
															Scoreboard _sc = _ent.getLevel().getScoreboard();
															Objective _so = _sc.getObjective(score);
															if (_so != null)
																return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
															return 0;
														}
													}.getScore("warpx", entity)) + " " + (new Object() {
														public int getScore(String score, Entity _ent) {
															Scoreboard _sc = _ent.getLevel().getScoreboard();
															Objective _so = _sc.getObjective(score);
															if (_so != null)
																return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
															return 0;
														}
													}.getScore("warpy", entity)) + " " + (new Object() {
														public int getScore(String score, Entity _ent) {
															Scoreboard _sc = _ent.getLevel().getScoreboard();
															Objective _so = _sc.getObjective(score);
															if (_so != null)
																return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
															return 0;
														}
													}.getScore("warpz", entity))));
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level.isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
													("/execute in minecraft:overworld run spawnpoint @s " + (new Object() {
														public int getScore(String score, Entity _ent) {
															Scoreboard _sc = _ent.getLevel().getScoreboard();
															Objective _so = _sc.getObjective(score);
															if (_so != null)
																return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
															return 0;
														}
													}.getScore("warpx", entity)) + " " + (new Object() {
														public int getScore(String score, Entity _ent) {
															Scoreboard _sc = _ent.getLevel().getScoreboard();
															Objective _so = _sc.getObjective(score);
															if (_so != null)
																return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
															return 0;
														}
													}.getScore("warpy", entity)) + " " + (new Object() {
														public int getScore(String score, Entity _ent) {
															Scoreboard _sc = _ent.getLevel().getScoreboard();
															Objective _so = _sc.getObjective(score);
															if (_so != null)
																return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
															return 0;
														}
													}.getScore("warpz", entity))));
										}
									}
									if (entity instanceof ServerPlayer _player) {
										Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gilded_doom:freeatlast"));
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											Iterator _iterator = _ap.getRemainingCriteria().iterator();
											while (_iterator.hasNext())
												_player.getAdvancements().award(_adv, (String) _iterator.next());
										}
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.getLevel().getScoreboard();
										Objective _so = _sc.getObjective("DuckSouls");
										if (_so == null)
											_so = _sc.addObjective("DuckSouls", ObjectiveCriteria.DUMMY, Component.literal("DuckSouls"), ObjectiveCriteria.RenderType.INTEGER);
										_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.getLevel().getScoreboard();
										Objective _so = _sc.getObjective("WitherSouls");
										if (_so == null)
											_so = _sc.addObjective("WitherSouls", ObjectiveCriteria.DUMMY, Component.literal("WitherSouls"), ObjectiveCriteria.RenderType.INTEGER);
										_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.getLevel().getScoreboard();
										Objective _so = _sc.getObjective("PiglinBruteSouls");
										if (_so == null)
											_so = _sc.addObjective("PiglinBruteSouls", ObjectiveCriteria.DUMMY, Component.literal("PiglinBruteSouls"), ObjectiveCriteria.RenderType.INTEGER);
										_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
									}
								} else {
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.getLevel().getScoreboard();
										Objective _so = _sc.getObjective("purgatory");
										if (_so == null)
											_so = _sc.addObjective("purgatory", ObjectiveCriteria.DUMMY, Component.literal("purgatory"), ObjectiveCriteria.RenderType.INTEGER);
										_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
									}
									PurgatoryAmalgamRightclickedProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
								}
								return;
							}
						});
					}
				}.startDelay(world);
			}
		} else {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(GildedDoomModMobEffects.GILDED_STASIS, 60, 0));
			new Object() {
				private int ticks = 0;

				public void startDelay(LevelAccessor world) {
					ServerTickEvents.END_SERVER_TICK.register((server) -> {
						this.ticks++;
						if (this.ticks == 60) {
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
											_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "/execute in minecraft:overworld run spawnpoint @s ~ ~ ~");
								}
							}
							if (entity instanceof Player _player && !_player.level.isClientSide())
								_player.displayClientMessage(Component.literal("Respawn Set (In Overworld)"), false);
							return;
						}
					});
				}
			}.startDelay(world);
		}
	}
}
