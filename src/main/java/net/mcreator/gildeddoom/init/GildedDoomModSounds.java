
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gildeddoom.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class GildedDoomModSounds {
	public static SoundEvent GOT_ANY_GRAPES = new SoundEvent(new ResourceLocation("gilded_doom", "got_any_grapes"));
	public static SoundEvent GOT_ANY_GLUE = new SoundEvent(new ResourceLocation("gilded_doom", "got_any_glue"));
	public static SoundEvent ULTIMATE_POWER_CHARGE_UP = new SoundEvent(new ResourceLocation("gilded_doom", "ultimate_power_charge_up"));
	public static SoundEvent ANCIENT_HAMMER_SLAM = new SoundEvent(new ResourceLocation("gilded_doom", "ancient_hammer_slam"));
	public static SoundEvent ENCHANTMENT_TORRENT = new SoundEvent(new ResourceLocation("gilded_doom", "enchantment_torrent"));

	public static void load() {
		Registry.register(Registry.SOUND_EVENT, new ResourceLocation("gilded_doom", "got_any_grapes"), GOT_ANY_GRAPES);
		Registry.register(Registry.SOUND_EVENT, new ResourceLocation("gilded_doom", "got_any_glue"), GOT_ANY_GLUE);
		Registry.register(Registry.SOUND_EVENT, new ResourceLocation("gilded_doom", "ultimate_power_charge_up"), ULTIMATE_POWER_CHARGE_UP);
		Registry.register(Registry.SOUND_EVENT, new ResourceLocation("gilded_doom", "ancient_hammer_slam"), ANCIENT_HAMMER_SLAM);
		Registry.register(Registry.SOUND_EVENT, new ResourceLocation("gilded_doom", "enchantment_torrent"), ENCHANTMENT_TORRENT);
	}
}
