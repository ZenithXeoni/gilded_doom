package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;

import net.mcreator.gildeddoom.init.GildedDoomModSounds;
import net.mcreator.gildeddoom.init.GildedDoomModItems;
import net.mcreator.gildeddoom.init.GildedDoomModEnchantments;
import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;

import java.util.Map;
import java.util.HashMap;

public class HammerEnchantsProcedure {
	public HammerEnchantsProcedure() {
		ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, damageSource, amount) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("entity", entity);
			dependencies.put("x", entity.getX());
			dependencies.put("y", entity.getY());
			dependencies.put("z", entity.getZ());
			dependencies.put("world", entity.level);
			dependencies.put("sourceentity", damageSource.getEntity());
			dependencies.put("immediatesourceentity", damageSource.getDirectEntity());
			dependencies.put("amount", amount);
			execute(dependencies);
			return true;
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure HammerEnchants!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency x for procedure HammerEnchants!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency y for procedure HammerEnchants!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency z for procedure HammerEnchants!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure HammerEnchants!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency sourceentity for procedure HammerEnchants!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (EnchantmentHelper.getItemEnchantmentLevel(GildedDoomModEnchantments.TORRENT, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.ANCIENT_HAMMER)) {
			if (sourceentity.isShiftKeyDown() && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.GILDED_BANISHER) {
				entity.setDeltaMovement(new Vec3(0, (-20), 0));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), GildedDoomModSounds.ANCIENT_HAMMER_SLAM, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, GildedDoomModSounds.ANCIENT_HAMMER_SLAM, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.SOULFORGED_HAMMER) {
				entity.setDeltaMovement(new Vec3(0, 1, 0));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), GildedDoomModSounds.ENCHANTMENT_TORRENT, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, GildedDoomModSounds.ENCHANTMENT_TORRENT, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 0.5) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 30, 0));
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 0.25) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 0));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 0));
				}
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 1));
				entity.setDeltaMovement(new Vec3(0, 1, 0));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), GildedDoomModSounds.ENCHANTMENT_TORRENT, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, GildedDoomModSounds.ENCHANTMENT_TORRENT, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(GildedDoomModEnchantments.KNOCKOUT, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0 && Mth.nextInt(RandomSource.create(), 1, 4) == 1
				&& !(entity instanceof LivingEntity _livEnt ? _livEnt.isBlocking() : false)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1, (float) 0.75);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1, (float) 0.75, false);
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 0.5) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.SOULFORGED_HAMMER ? 150 : 100), 0));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 0.25) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.SOULFORGED_HAMMER ? 80 : 120), 0));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.SOULFORGED_HAMMER ? 40 : 60), 0));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(GildedDoomModEnchantments.FORTITUDE, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= 0.25) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.HELLFORGED_HAMMER) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 1));
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100, 1));
				} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.SOULFORGED_HAMMER) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1));
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1));
				} else {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1));
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= 0.5) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.HELLFORGED_HAMMER) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 0));
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100, 0));
				} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.SOULFORGED_HAMMER) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0));
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
				} else {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0));
					if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
				}
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(GildedDoomModEnchantments.RARITY, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60, 2));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), SoundEvents.ELDER_GUARDIAN_CURSE, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.ELDER_GUARDIAN_CURSE, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}
