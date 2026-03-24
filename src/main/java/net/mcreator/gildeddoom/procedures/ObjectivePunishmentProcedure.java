package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

import java.util.Map;
import java.util.HashMap;

public class ObjectivePunishmentProcedure {
	public ObjectivePunishmentProcedure() {
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
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure ObjectivePunishment!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency x for procedure ObjectivePunishment!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency y for procedure ObjectivePunishment!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency z for procedure ObjectivePunishment!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure ObjectivePunishment!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("ObjectiveComplete", entity) == 0 && new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("user_has_ultimate_power", entity) > 0) {
			if (new Object() {
				public int getScore(String score, Entity _ent) {
					Scoreboard _sc = _ent.getLevel().getScoreboard();
					Objective _so = _sc.getObjective(score);
					if (_so != null)
						return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
					return 0;
				}
			}.getScore("user_has_ultimate_power", entity) == 1) {
				if (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("deathcurse", entity) == 3) {
					if (!((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("gilded_doom:purgatory_dimension"))))) {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(Component.literal(
									"\u00A76<???> It appears you cannot complete a simple task. You have proven useless to me, but because you give me power by merely existing under contract, I am going to send you to Purgatory so you remain eternal."),
									false);
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.getLevel().getScoreboard();
							Objective _so = _sc.getObjective("purgatory");
							if (_so == null)
								_so = _sc.addObjective("purgatory", ObjectiveCriteria.DUMMY, Component.literal("purgatory"), ObjectiveCriteria.RenderType.INTEGER);
							_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"playsound minecraft:block.respawn_anchor.ambient master @a ~ ~ ~ 1 0.5");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"playsound minecraft:block.respawn_anchor.deplete master @a ~ ~ ~ 1 0.5");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"playsound minecraft:entity.wither.spawn master @a ~ ~ ~ 1 0.73");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"playsound minecraft:ambient.cave master @a ~ ~ ~ 1 0.5");
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						PurgatoryAmalgamRightclickedProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("entity", entity).build());
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"tellraw @a {\"text\":\"No mortal shall escape the Gilded Embrace of Doom.\",\"italic\":true,\"color\":\"dark_red\"}");
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(Component.literal(
									"\u00A74<???> M Y Z K E L O N. That woman\u2026 She thinks I'm just her storage room for all of her \u201Ccontractees\u201D. I will give you another chance to live since your life was cut short. All I ask is for you to remove a chunk of the vermin inside of my land. And if you can, P L E A S E, Kill Myzkelon, I am tired of her bringing even more vermin into this land. She is not as evil as Loza Gearnight, but she must stop."),
									false);
					}
				} else if (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("deathcurse", entity) > 0) {
					{
						Entity _ent = entity;
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective("deathcurse");
						if (_so == null)
							_so = _sc.addObjective("deathcurse", ObjectiveCriteria.DUMMY, Component.literal("deathcurse"), ObjectiveCriteria.RenderType.INTEGER);
						_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
							public int getScore(String score, Entity _ent) {
								Scoreboard _sc = _ent.getLevel().getScoreboard();
								Objective _so = _sc.getObjective(score);
								if (_so != null)
									return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
								return 0;
							}
						}.getScore("deathcurse", entity) + 1));
					}
					if (new Object() {
						public int getScore(String score, Entity _ent) {
							Scoreboard _sc = _ent.getLevel().getScoreboard();
							Objective _so = _sc.getObjective(score);
							if (_so != null)
								return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
							return 0;
						}
					}.getScore("deathcurse", entity) == 2) {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76<???> You signed up for this, I'm not going back on my word."), false);
					}
					if (new Object() {
						public int getScore(String score, Entity _ent) {
							Scoreboard _sc = _ent.getLevel().getScoreboard();
							Objective _so = _sc.getObjective(score);
							if (_so != null)
								return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
							return 0;
						}
					}.getScore("deathcurse", entity) == 3) {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76<???> I will give you one more attempt, if you fail, you are useless to me."), false);
					}
				} else {
					{
						Entity _ent = entity;
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective("deathcurse");
						if (_so == null)
							_so = _sc.addObjective("deathcurse", ObjectiveCriteria.DUMMY, Component.literal("deathcurse"), ObjectiveCriteria.RenderType.INTEGER);
						_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("\u00A76<???> Really?"), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("You have reached In development content, Good Job :3"), false);
			}
		}
	}
}
