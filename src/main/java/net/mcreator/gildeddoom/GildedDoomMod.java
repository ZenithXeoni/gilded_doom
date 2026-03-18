/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package net.mcreator.gildeddoom;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.mcreator.gildeddoom.network.GildedDoomModVariables;
import net.mcreator.gildeddoom.init.GildedDoomModTrades;
import net.mcreator.gildeddoom.init.GildedDoomModTabs;
import net.mcreator.gildeddoom.init.GildedDoomModSounds;
import net.mcreator.gildeddoom.init.GildedDoomModProcedures;
import net.mcreator.gildeddoom.init.GildedDoomModMobEffects;
import net.mcreator.gildeddoom.init.GildedDoomModItems;
import net.mcreator.gildeddoom.init.GildedDoomModGameRules;
import net.mcreator.gildeddoom.init.GildedDoomModFeatures;
import net.mcreator.gildeddoom.init.GildedDoomModEntities;
import net.mcreator.gildeddoom.init.GildedDoomModEnchantments;
import net.mcreator.gildeddoom.init.GildedDoomModBlocks;

import net.fabricmc.api.ModInitializer;

public class GildedDoomMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "gilded_doom";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing GildedDoomMod");

		GildedDoomModTabs.load();
		GildedDoomModGameRules.load();
		GildedDoomModEnchantments.load();
		GildedDoomModMobEffects.load();

		GildedDoomModEntities.load();
		GildedDoomModBlocks.load();
		GildedDoomModItems.load();

		GildedDoomModFeatures.load();

		GildedDoomModProcedures.load();

		GildedDoomModTrades.registerTrades();
		GildedDoomModSounds.load();
		GildedDoomModVariables.SyncJoin();
		GildedDoomModVariables.SyncChangeWorld();
	}
}
