package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.gildeddoom.init.GildedDoomModGameRules;
import net.mcreator.gildeddoom.GildedDoomMod;

import java.util.Map;

public class BrutalTomeRightclickedProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure BrutalTomeRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency x for procedure BrutalTomeRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency y for procedure BrutalTomeRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency z for procedure BrutalTomeRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure BrutalTomeRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency itemstack for procedure BrutalTomeRightclicked!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (!world.getLevelData().getGameRules().getBoolean(GildedDoomModGameRules.BOOK_UNLOCKED) && world.getLevelData().getGameRules().getBoolean(GildedDoomModGameRules.ALLOWGILDEDBANISHMENT) && entity.isShiftKeyDown()) {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level.getServer(), _ent),
							"tellraw @a [\"\",{\"text\":\"You sense a demonic presence rise from an unknown place to The Mortal Realm. \u2014 one has summoned the Deal, but cannot claim it. ..-. --- .-. / -. --- .--\",\"italic\":true,\"color\":\"gold\",\"bold\":true}]");
				}
			}
			(itemstack).shrink(1);
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "give @s gilded_doom:book_of_gilded_banishment");
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), SoundEvents.CHAIN_BREAK, SoundSource.MASTER, 100, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.CHAIN_BREAK, SoundSource.MASTER, 100, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), SoundEvents.CHAIN_PLACE, SoundSource.MASTER, 100, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.CHAIN_PLACE, SoundSource.MASTER, 100, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), SoundEvents.CHAIN_FALL, SoundSource.MASTER, 100, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.CHAIN_FALL, SoundSource.MASTER, 100, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), SoundEvents.CHAIN_HIT, SoundSource.MASTER, 100, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.CHAIN_HIT, SoundSource.MASTER, 100, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), SoundEvents.BEACON_POWER_SELECT, SoundSource.MASTER, 100, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.BEACON_POWER_SELECT, SoundSource.MASTER, 100, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), SoundEvents.WITHER_SPAWN, SoundSource.MASTER, 100, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.WITHER_SPAWN, SoundSource.MASTER, 100, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), SoundEvents.BEACON_AMBIENT, SoundSource.MASTER, 100, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, SoundEvents.BEACON_AMBIENT, SoundSource.MASTER, 100, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level)
				_level.getGameRules().getRule(GildedDoomModGameRules.BOOK_UNLOCKED).set(true, _level.getServer());
		}
	}
}
