package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.gildeddoom.init.GildedDoomModSounds;
import net.mcreator.gildeddoom.init.GildedDoomModEnchantments;
import net.mcreator.gildeddoom.GildedDoomMod;

import java.util.Map;

public class AncientHammerLivingEntityIsHitWithToolProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure AncientHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency x for procedure AncientHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency y for procedure AncientHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency z for procedure AncientHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure AncientHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency sourceentity for procedure AncientHammerLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency itemstack for procedure AncientHammerLivingEntityIsHitWithTool!");
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
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0));
			}
		} else {
			entity.setDeltaMovement(new Vec3(0, (-20), 0));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), GildedDoomModSounds.ANCIENT_HAMMER_SLAM, SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, GildedDoomModSounds.ANCIENT_HAMMER_SLAM, SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"playsound enchancement:entity.generic.impact player @p ~ ~ ~ 1 1");
			HammerEnchantsProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).put("entity", entity).put("sourceentity", sourceentity).build());
		}
	}
}
