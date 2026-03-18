
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gildeddoom.init;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.gildeddoom.enchantment.TorrentEnchantment;
import net.mcreator.gildeddoom.enchantment.KnockoutEnchantment;
import net.mcreator.gildeddoom.enchantment.FortitudeEnchantment;
import net.mcreator.gildeddoom.GildedDoomMod;

public class GildedDoomModEnchantments {
	public static Enchantment TORRENT;
	public static Enchantment FORTITUDE;
	public static Enchantment KNOCKOUT;

	public static void load() {
		TORRENT = Registry.register(Registry.ENCHANTMENT, new ResourceLocation(GildedDoomMod.MODID, "torrent"), new TorrentEnchantment());
		FORTITUDE = Registry.register(Registry.ENCHANTMENT, new ResourceLocation(GildedDoomMod.MODID, "fortitude"), new FortitudeEnchantment());
		KNOCKOUT = Registry.register(Registry.ENCHANTMENT, new ResourceLocation(GildedDoomMod.MODID, "knockout"), new KnockoutEnchantment());
	}
}
