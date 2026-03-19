package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.gildeddoom.init.GildedDoomModItems;
import net.mcreator.gildeddoom.GildedDoomMod;

import java.util.Map;

public class FreeMeRightclickedProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure FreeMeRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency x for procedure FreeMeRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency y for procedure FreeMeRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency z for procedure FreeMeRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure FreeMeRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency itemstack for procedure FreeMeRightclicked!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (world.isClientSide())
			Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(GildedDoomModItems.FREE_ME));
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), SoundEvents.TOTEM_USE, SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, SoundEvents.TOTEM_USE, SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.getLevel().getScoreboard();
			Objective _so = _sc.getObjective("BlazeSouls");
			if (_so == null)
				_so = _sc.addObjective("BlazeSouls", ObjectiveCriteria.DUMMY, Component.literal("BlazeSouls"), ObjectiveCriteria.RenderType.INTEGER);
			_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(200);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.getLevel().getScoreboard();
			Objective _so = _sc.getObjective("SkeletonSouls");
			if (_so == null)
				_so = _sc.addObjective("SkeletonSouls", ObjectiveCriteria.DUMMY, Component.literal("SkeletonSouls"), ObjectiveCriteria.RenderType.INTEGER);
			_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(200);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.getLevel().getScoreboard();
			Objective _so = _sc.getObjective("PiglinSouls");
			if (_so == null)
				_so = _sc.addObjective("PiglinSouls", ObjectiveCriteria.DUMMY, Component.literal("PiglinSouls"), ObjectiveCriteria.RenderType.INTEGER);
			_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(200);
		}
		(itemstack).shrink(1);
	}
}
