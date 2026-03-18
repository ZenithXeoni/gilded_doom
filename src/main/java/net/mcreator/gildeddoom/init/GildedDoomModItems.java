
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gildeddoom.init;

import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.gildeddoom.item.WitheringTomeItem;
import net.mcreator.gildeddoom.item.WarpedAmalgamItem;
import net.mcreator.gildeddoom.item.TrackingTomeItem;
import net.mcreator.gildeddoom.item.SoulforgedHammerItem;
import net.mcreator.gildeddoom.item.PurgatoryAmalgamItem;
import net.mcreator.gildeddoom.item.IronHammerItem;
import net.mcreator.gildeddoom.item.InfernalScrapItem;
import net.mcreator.gildeddoom.item.InfernalCoreItem;
import net.mcreator.gildeddoom.item.ImmunityTomeItem;
import net.mcreator.gildeddoom.item.HellforgedHammerItem;
import net.mcreator.gildeddoom.item.GildedIngotItem;
import net.mcreator.gildeddoom.item.GildedCoreItem;
import net.mcreator.gildeddoom.item.GildedContractItem;
import net.mcreator.gildeddoom.item.GildedBruteItem;
import net.mcreator.gildeddoom.item.GildedBanisherItem;
import net.mcreator.gildeddoom.item.FreeMeItem;
import net.mcreator.gildeddoom.item.DemonicDustItem;
import net.mcreator.gildeddoom.item.CleansingTomeItem;
import net.mcreator.gildeddoom.item.ChippedAmalgamItem;
import net.mcreator.gildeddoom.item.BrutalTomeItem;
import net.mcreator.gildeddoom.item.BookOfGildedBanishmentItem;
import net.mcreator.gildeddoom.item.BloodGrapesItem;
import net.mcreator.gildeddoom.item.AncientHammerItem;
import net.mcreator.gildeddoom.GildedDoomMod;

public class GildedDoomModItems {
	public static Item IRON_HAMMER;
	public static Item ANCIENT_HAMMER;
	public static Item GILDED_BANISHER;
	public static Item HELLFORGED_HAMMER;
	public static Item SOULFORGED_HAMMER;
	public static Item GILDED_CONTRACT;
	public static Item BRUTAL_TOME;
	public static Item WITHERING_TOME;
	public static Item INFERNAL_SCRAP;
	public static Item INFERNAL_CORE;
	public static Item GILDED_CORE;
	public static Item PURGATORY_AMALGAM;
	public static Item PURGATORY_NYLIUM;
	public static Item PURGATORY_STONE;
	public static Item POLISHED_PURGATORY_STONE;
	public static Item POLISHED_PURGATORY_STONE_BRICKS;
	public static Item CRACKED_POLISHED_PURGATORY_BRICKS;
	public static Item CHISELED_POLISHED_PURGATORY_BRICKS;
	public static Item GILDED_PURGATORY_STONE;
	public static Item IRON_INFUSED_PURGATORY_STONE;
	public static Item DUCK_SPAWN_EGG;
	public static Item SAVAGE_DUCK_SPAWN_EGG;
	public static Item IMMUNITY_TOME;
	public static Item GILDED_INGOT;
	public static Item GILDED_BRUTE_HELMET;
	public static Item GILDED_BRUTE_CHESTPLATE;
	public static Item GILDED_BRUTE_LEGGINGS;
	public static Item GILDED_BRUTE_BOOTS;
	public static Item TRACKING_TOME;
	public static Item WARPED_AMALGAM;
	public static Item FREE_ME;
	public static Item CLEANSING_TOME;
	public static Item POLISHED_PURGATORY_STONE_BRICK_WALL;
	public static Item POLISHED_PURGATORY_STONE_WALL;
	public static Item CRACKED_PURGATORY_STONE_BRICK_WALL;
	public static Item PURGATORY_STONE_SLAB;
	public static Item POLISHED_PURGATORY_STONE_SLAB;
	public static Item POLISHED_PURGATORY_STONE_BRICK_SLAB;
	public static Item CRACKED_POLISHED_PURGATORY_BRICK_SLAB;
	public static Item PURGATORY_STONE_STAIRS;
	public static Item POLISHED_PURGATORY_STONE_STAIRS;
	public static Item POLISHED_PURGATORY_STONE_BRICK_STAIRS;
	public static Item CRACKED_POLISHED_PURGATORY_STONE_STAIRS;
	public static Item GILDED_PURGATORY_STONE_SLAB;
	public static Item IRON_INFUSED_PURGATORY_STONE_SLAB;
	public static Item POLISHED_PURGATORY_FENCE;
	public static Item BLOOD_GRAPES;
	public static Item CHIPPED_AMALGAM;
	public static Item BLEEDING_OBSIDAN;
	public static Item DEMENANITE_ORE;
	public static Item DEMONIC_DUST;
	public static Item BOOK_OF_GILDED_BANISHMENT;

	public static void load() {
		IRON_HAMMER = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "iron_hammer"), new IronHammerItem());
		ANCIENT_HAMMER = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "ancient_hammer"), new AncientHammerItem());
		GILDED_BANISHER = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "gilded_banisher"), new GildedBanisherItem());
		HELLFORGED_HAMMER = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "hellforged_hammer"), new HellforgedHammerItem());
		SOULFORGED_HAMMER = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "soulforged_hammer"), new SoulforgedHammerItem());
		GILDED_CONTRACT = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "gilded_contract"), new GildedContractItem());
		BRUTAL_TOME = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "brutal_tome"), new BrutalTomeItem());
		WITHERING_TOME = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "withering_tome"), new WitheringTomeItem());
		INFERNAL_SCRAP = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "infernal_scrap"), new InfernalScrapItem());
		INFERNAL_CORE = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "infernal_core"), new InfernalCoreItem());
		GILDED_CORE = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "gilded_core"), new GildedCoreItem());
		PURGATORY_AMALGAM = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "purgatory_amalgam"), new PurgatoryAmalgamItem());
		PURGATORY_NYLIUM = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "purgatory_nylium"), new BlockItem(GildedDoomModBlocks.PURGATORY_NYLIUM, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		PURGATORY_STONE = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "purgatory_stone"), new BlockItem(GildedDoomModBlocks.PURGATORY_STONE, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		POLISHED_PURGATORY_STONE = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone"),
				new BlockItem(GildedDoomModBlocks.POLISHED_PURGATORY_STONE, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		POLISHED_PURGATORY_STONE_BRICKS = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_bricks"),
				new BlockItem(GildedDoomModBlocks.POLISHED_PURGATORY_STONE_BRICKS, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		CRACKED_POLISHED_PURGATORY_BRICKS = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "cracked_polished_purgatory_bricks"),
				new BlockItem(GildedDoomModBlocks.CRACKED_POLISHED_PURGATORY_BRICKS, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		CHISELED_POLISHED_PURGATORY_BRICKS = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "chiseled_polished_purgatory_bricks"),
				new BlockItem(GildedDoomModBlocks.CHISELED_POLISHED_PURGATORY_BRICKS, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		GILDED_PURGATORY_STONE = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "gilded_purgatory_stone"),
				new BlockItem(GildedDoomModBlocks.GILDED_PURGATORY_STONE, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		IRON_INFUSED_PURGATORY_STONE = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "iron_infused_purgatory_stone"),
				new BlockItem(GildedDoomModBlocks.IRON_INFUSED_PURGATORY_STONE, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		DUCK_SPAWN_EGG = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "duck_spawn_egg"), new SpawnEggItem(GildedDoomModEntities.DUCK, -13312, -13312, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
		SAVAGE_DUCK_SPAWN_EGG = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "savage_duck_spawn_egg"),
				new SpawnEggItem(GildedDoomModEntities.SAVAGE_DUCK, -3407821, -10092544, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
		IMMUNITY_TOME = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "immunity_tome"), new ImmunityTomeItem());
		GILDED_INGOT = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "gilded_ingot"), new GildedIngotItem());
		GILDED_BRUTE_HELMET = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "gilded_brute_helmet"), new GildedBruteItem.Helmet());
		GILDED_BRUTE_CHESTPLATE = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "gilded_brute_chestplate"), new GildedBruteItem.Chestplate());
		GILDED_BRUTE_LEGGINGS = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "gilded_brute_leggings"), new GildedBruteItem.Leggings());
		GILDED_BRUTE_BOOTS = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "gilded_brute_boots"), new GildedBruteItem.Boots());
		TRACKING_TOME = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "tracking_tome"), new TrackingTomeItem());
		WARPED_AMALGAM = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "warped_amalgam"), new WarpedAmalgamItem());
		FREE_ME = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "free_me"), new FreeMeItem());
		CLEANSING_TOME = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "cleansing_tome"), new CleansingTomeItem());
		POLISHED_PURGATORY_STONE_BRICK_WALL = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_brick_wall"),
				new BlockItem(GildedDoomModBlocks.POLISHED_PURGATORY_STONE_BRICK_WALL, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		POLISHED_PURGATORY_STONE_WALL = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_wall"),
				new BlockItem(GildedDoomModBlocks.POLISHED_PURGATORY_STONE_WALL, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		CRACKED_PURGATORY_STONE_BRICK_WALL = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "cracked_purgatory_stone_brick_wall"),
				new BlockItem(GildedDoomModBlocks.CRACKED_PURGATORY_STONE_BRICK_WALL, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		PURGATORY_STONE_SLAB = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "purgatory_stone_slab"),
				new BlockItem(GildedDoomModBlocks.PURGATORY_STONE_SLAB, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		POLISHED_PURGATORY_STONE_SLAB = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_slab"),
				new BlockItem(GildedDoomModBlocks.POLISHED_PURGATORY_STONE_SLAB, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		POLISHED_PURGATORY_STONE_BRICK_SLAB = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_brick_slab"),
				new BlockItem(GildedDoomModBlocks.POLISHED_PURGATORY_STONE_BRICK_SLAB, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		CRACKED_POLISHED_PURGATORY_BRICK_SLAB = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "cracked_polished_purgatory_brick_slab"),
				new BlockItem(GildedDoomModBlocks.CRACKED_POLISHED_PURGATORY_BRICK_SLAB, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		PURGATORY_STONE_STAIRS = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "purgatory_stone_stairs"),
				new BlockItem(GildedDoomModBlocks.PURGATORY_STONE_STAIRS, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		POLISHED_PURGATORY_STONE_STAIRS = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_stairs"),
				new BlockItem(GildedDoomModBlocks.POLISHED_PURGATORY_STONE_STAIRS, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		POLISHED_PURGATORY_STONE_BRICK_STAIRS = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_brick_stairs"),
				new BlockItem(GildedDoomModBlocks.POLISHED_PURGATORY_STONE_BRICK_STAIRS, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		CRACKED_POLISHED_PURGATORY_STONE_STAIRS = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "cracked_polished_purgatory_stone_stairs"),
				new BlockItem(GildedDoomModBlocks.CRACKED_POLISHED_PURGATORY_STONE_STAIRS, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		GILDED_PURGATORY_STONE_SLAB = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "gilded_purgatory_stone_slab"),
				new BlockItem(GildedDoomModBlocks.GILDED_PURGATORY_STONE_SLAB, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		IRON_INFUSED_PURGATORY_STONE_SLAB = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "iron_infused_purgatory_stone_slab"),
				new BlockItem(GildedDoomModBlocks.IRON_INFUSED_PURGATORY_STONE_SLAB, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		POLISHED_PURGATORY_FENCE = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_fence"),
				new BlockItem(GildedDoomModBlocks.POLISHED_PURGATORY_FENCE, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		BLOOD_GRAPES = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "blood_grapes"), new BloodGrapesItem());
		CHIPPED_AMALGAM = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "chipped_amalgam"), new ChippedAmalgamItem());
		BLEEDING_OBSIDAN = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "bleeding_obsidan"), new BlockItem(GildedDoomModBlocks.BLEEDING_OBSIDAN, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		DEMENANITE_ORE = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "demenanite_ore"), new BlockItem(GildedDoomModBlocks.DEMENANITE_ORE, new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB)));
		DEMONIC_DUST = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "demonic_dust"), new DemonicDustItem());
		BOOK_OF_GILDED_BANISHMENT = Registry.register(Registry.ITEM, new ResourceLocation(GildedDoomMod.MODID, "book_of_gilded_banishment"), new BookOfGildedBanishmentItem());
	}
}
