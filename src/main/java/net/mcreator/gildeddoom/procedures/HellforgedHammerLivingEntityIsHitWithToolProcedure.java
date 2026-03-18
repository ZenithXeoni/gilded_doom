package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.gildeddoom.init.GildedDoomModMobEffects;
import net.mcreator.gildeddoom.init.GildedDoomModEnchantments;
import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.Map;

public class HellforgedHammerLivingEntityIsHitWithToolProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure HellforgedHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency x for procedure HellforgedHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency y for procedure HellforgedHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency z for procedure HellforgedHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure HellforgedHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency sourceentity for procedure HellforgedHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency itemstack for procedure HellforgedHammerLivingEntityIsHitWithTool!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (EnchantmentHelper.getItemEnchantmentLevel(GildedDoomModEnchantments.RARITY, itemstack) != 0) {
			if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), SoundEvents.WITHER_SKELETON_HURT, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.WITHER_SKELETON_HURT, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(GildedDoomModMobEffects.THE_ECHO_FALL_EXPERIENCE, 160, 0));
			}
		} else {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.isBlocking() : false)) {
				if (Mth.nextInt(RandomSource.create(), 1, 4) == 1 || (entity.level.dimension()) == Level.NETHER) {
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "particle minecraft:flame ~ ~2 ~ .5 .5 .5 1 50 normal");
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), SoundEvents.BLAZE_SHOOT, SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, SoundEvents.BLAZE_SHOOT, SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					new Object() {
						private int ticks = 0;

						public void startDelay(LevelAccessor world) {
							ServerTickEvents.END_SERVER_TICK.register((server) -> {
								this.ticks++;
								if (this.ticks == 1) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), SoundEvents.FIREWORK_ROCKET_LARGE_BLAST, SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, SoundEvents.FIREWORK_ROCKET_LARGE_BLAST, SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), SoundEvents.FIREWORK_ROCKET_BLAST, SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, SoundEvents.FIREWORK_ROCKET_BLAST, SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									return;
								}
							});
						}
					}.startDelay(world);
					entity.setSecondsOnFire(20);
				}
				if (Mth.nextInt(RandomSource.create(), 1, 16) == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), SoundEvents.WITHER_SKELETON_HURT, SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, SoundEvents.WITHER_SKELETON_HURT, SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(GildedDoomModMobEffects.THE_ECHO_FALL_EXPERIENCE, 160, 0));
				}
			}
			HammerEnchantsProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).put("entity", entity).put("sourceentity", sourceentity).build());
		}
	}
}
