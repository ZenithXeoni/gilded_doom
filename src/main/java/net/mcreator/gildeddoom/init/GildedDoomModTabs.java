
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gildeddoom.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

public class GildedDoomModTabs {
	public static CreativeModeTab TAB_GILDED_DOOM;
	public static CreativeModeTab TAB_PURGATORY_TAB;

	public static void load() {
		TAB_GILDED_DOOM = FabricItemGroupBuilder.create(new ResourceLocation("gilded_doom", "gilded_doom")).icon(() -> new ItemStack(GildedDoomModItems.GILDED_CONTRACT)).build();
		TAB_PURGATORY_TAB = FabricItemGroupBuilder.create(new ResourceLocation("gilded_doom", "purgatory_tab")).icon(() -> new ItemStack(GildedDoomModItems.PURGATORY_AMALGAM)).build();
	}
}
