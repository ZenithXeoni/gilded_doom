
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gildeddoom.init;

import net.minecraft.world.level.GameRules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;

public class GildedDoomModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> ALLOWGILDEDBANISHMENT;
	public static GameRules.Key<GameRules.BooleanValue> BOOK_UNLOCKED;
	public static GameRules.Key<GameRules.BooleanValue> DO_REAL_BANS;

	public static void load() {
		ALLOWGILDEDBANISHMENT = GameRuleRegistry.register("allowgildedbanishment", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));
		BOOK_UNLOCKED = GameRuleRegistry.register("book_unlocked", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false));
		DO_REAL_BANS = GameRuleRegistry.register("do_real_bans", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(true));
	}
}
