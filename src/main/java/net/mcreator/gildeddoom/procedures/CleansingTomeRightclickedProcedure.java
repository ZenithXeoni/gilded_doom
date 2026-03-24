package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.gildeddoom.init.GildedDoomModMobEffects;
import net.mcreator.gildeddoom.GildedDoomMod;

import java.util.Map;

public class CleansingTomeRightclickedProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure CleansingTomeRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency x for procedure CleansingTomeRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency y for procedure CleansingTomeRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency z for procedure CleansingTomeRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure CleansingTomeRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency itemstack for procedure CleansingTomeRightclicked!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(GildedDoomModMobEffects.PENDING_DEATH) : false) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("pendingdeath");
				if (_so == null)
					_so = _sc.addObjective("pendingdeath", ObjectiveCriteria.DUMMY, Component.literal("pendingdeath"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(5);
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(GildedDoomModMobEffects.PENDING_DEATH);
			if (new Object() {
				public int getScore(String score, Entity _ent) {
					Scoreboard _sc = _ent.getLevel().getScoreboard();
					Objective _so = _sc.getObjective(score);
					if (_so != null)
						return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
					return 0;
				}
			}.getScore("deathcurse", entity) == 3) {
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
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, y, z, 10, Explosion.BlockInteraction.DESTROY);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @a {\"text\":\"No mortal shall escape the Gilded Embrace of Doom.\",\"italic\":true,\"color\":\"dark_red\"}");
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74 <???> That wasn't fair. I will give you another chance to live since your life was cut short. All I ask is for you to remove a chunk of the vermin inside of my land."),
							false);
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
			} else {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.getLevel().getScoreboard();
					Objective _so = _sc.getObjective("deathcurse");
					if (_so == null)
						_so = _sc.addObjective("deathcurse", ObjectiveCriteria.DUMMY, Component.literal("deathcurse"), ObjectiveCriteria.RenderType.INTEGER);
					_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), SoundEvents.WITHER_DEATH, SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.WITHER_DEATH, SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			(itemstack).shrink(1);
		}
	}
}
