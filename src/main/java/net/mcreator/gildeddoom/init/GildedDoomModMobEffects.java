
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gildeddoom.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.gildeddoom.potion.UltimatePowerMobEffect;
import net.mcreator.gildeddoom.potion.TheEchoFallExpirenceMobEffect;
import net.mcreator.gildeddoom.potion.PendingDeathMobEffect;
import net.mcreator.gildeddoom.potion.GildedStasisMobEffect;
import net.mcreator.gildeddoom.potion.GildedImmunityMobEffect;
import net.mcreator.gildeddoom.potion.GildedEmpowermentMobEffect;
import net.mcreator.gildeddoom.potion.DeathsMarkMobEffect;
import net.mcreator.gildeddoom.GildedDoomMod;

public class GildedDoomModMobEffects {
	public static MobEffect THE_ECHO_FALL_EXPERIENCE;
	public static MobEffect DEATHS_MARK;
	public static MobEffect PENDING_DEATH;
	public static MobEffect ULTIMATE_POWER;
	public static MobEffect GILDED_STASIS;
	public static MobEffect GILDED_IMMUNITY;
	public static MobEffect GILDED_EMPOWERMENT;

	public static void load() {
		THE_ECHO_FALL_EXPERIENCE = Registry.register(Registry.MOB_EFFECT, new ResourceLocation(GildedDoomMod.MODID, "the_echo_fall_experience"), new TheEchoFallExpirenceMobEffect());
		DEATHS_MARK = Registry.register(Registry.MOB_EFFECT, new ResourceLocation(GildedDoomMod.MODID, "deaths_mark"), new DeathsMarkMobEffect());
		PENDING_DEATH = Registry.register(Registry.MOB_EFFECT, new ResourceLocation(GildedDoomMod.MODID, "pending_death"), new PendingDeathMobEffect());
		ULTIMATE_POWER = Registry.register(Registry.MOB_EFFECT, new ResourceLocation(GildedDoomMod.MODID, "ultimate_power"), new UltimatePowerMobEffect());
		GILDED_STASIS = Registry.register(Registry.MOB_EFFECT, new ResourceLocation(GildedDoomMod.MODID, "gilded_stasis"), new GildedStasisMobEffect());
		GILDED_IMMUNITY = Registry.register(Registry.MOB_EFFECT, new ResourceLocation(GildedDoomMod.MODID, "gilded_immunity"), new GildedImmunityMobEffect());
		GILDED_EMPOWERMENT = Registry.register(Registry.MOB_EFFECT, new ResourceLocation(GildedDoomMod.MODID, "gilded_empowerment"), new GildedEmpowermentMobEffect());
	}
}
