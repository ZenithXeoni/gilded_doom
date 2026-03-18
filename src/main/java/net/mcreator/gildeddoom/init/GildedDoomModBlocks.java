
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gildeddoom.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.gildeddoom.block.PurgatoryStoneStairsBlock;
import net.mcreator.gildeddoom.block.PurgatoryStoneSlabBlock;
import net.mcreator.gildeddoom.block.PurgatoryStoneBlock;
import net.mcreator.gildeddoom.block.PurgatoryNyliumBlock;
import net.mcreator.gildeddoom.block.PolishedPurgatoryStoneWallBlock;
import net.mcreator.gildeddoom.block.PolishedPurgatoryStoneStairsBlock;
import net.mcreator.gildeddoom.block.PolishedPurgatoryStoneSlabBlock;
import net.mcreator.gildeddoom.block.PolishedPurgatoryStoneBricksBlock;
import net.mcreator.gildeddoom.block.PolishedPurgatoryStoneBrickWallBlock;
import net.mcreator.gildeddoom.block.PolishedPurgatoryStoneBrickStairsBlock;
import net.mcreator.gildeddoom.block.PolishedPurgatoryStoneBrickSlabBlock;
import net.mcreator.gildeddoom.block.PolishedPurgatoryStoneBlock;
import net.mcreator.gildeddoom.block.PolishedPurgatoryFenceBlock;
import net.mcreator.gildeddoom.block.IronInfusedPurgatoryStoneSlabBlock;
import net.mcreator.gildeddoom.block.IronInfusedPurgatoryStoneBlock;
import net.mcreator.gildeddoom.block.GildedPurgatoryStoneSlabBlock;
import net.mcreator.gildeddoom.block.GildedPurgatoryStoneBlock;
import net.mcreator.gildeddoom.block.DemenaniteOreBlock;
import net.mcreator.gildeddoom.block.CrackedPurgatoryStoneBrickWallBlock;
import net.mcreator.gildeddoom.block.CrackedPolishedPurgatoryStoneStairsBlock;
import net.mcreator.gildeddoom.block.CrackedPolishedPurgatoryBricksBlock;
import net.mcreator.gildeddoom.block.CrackedPolishedPurgatoryBrickSlabBlock;
import net.mcreator.gildeddoom.block.ChiseledPolishedPurgatoryBricksBlock;
import net.mcreator.gildeddoom.block.BleedingObsidanBlock;
import net.mcreator.gildeddoom.GildedDoomMod;

public class GildedDoomModBlocks {
	public static Block PURGATORY_NYLIUM;
	public static Block PURGATORY_STONE;
	public static Block POLISHED_PURGATORY_STONE;
	public static Block POLISHED_PURGATORY_STONE_BRICKS;
	public static Block CRACKED_POLISHED_PURGATORY_BRICKS;
	public static Block CHISELED_POLISHED_PURGATORY_BRICKS;
	public static Block GILDED_PURGATORY_STONE;
	public static Block IRON_INFUSED_PURGATORY_STONE;
	public static Block POLISHED_PURGATORY_STONE_BRICK_WALL;
	public static Block POLISHED_PURGATORY_STONE_WALL;
	public static Block CRACKED_PURGATORY_STONE_BRICK_WALL;
	public static Block PURGATORY_STONE_SLAB;
	public static Block POLISHED_PURGATORY_STONE_SLAB;
	public static Block POLISHED_PURGATORY_STONE_BRICK_SLAB;
	public static Block CRACKED_POLISHED_PURGATORY_BRICK_SLAB;
	public static Block PURGATORY_STONE_STAIRS;
	public static Block POLISHED_PURGATORY_STONE_STAIRS;
	public static Block POLISHED_PURGATORY_STONE_BRICK_STAIRS;
	public static Block CRACKED_POLISHED_PURGATORY_STONE_STAIRS;
	public static Block GILDED_PURGATORY_STONE_SLAB;
	public static Block IRON_INFUSED_PURGATORY_STONE_SLAB;
	public static Block POLISHED_PURGATORY_FENCE;
	public static Block BLEEDING_OBSIDAN;
	public static Block DEMENANITE_ORE;

	public static void load() {
		PURGATORY_NYLIUM = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "purgatory_nylium"), new PurgatoryNyliumBlock());
		PURGATORY_STONE = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "purgatory_stone"), new PurgatoryStoneBlock());
		POLISHED_PURGATORY_STONE = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone"), new PolishedPurgatoryStoneBlock());
		POLISHED_PURGATORY_STONE_BRICKS = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_bricks"), new PolishedPurgatoryStoneBricksBlock());
		CRACKED_POLISHED_PURGATORY_BRICKS = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "cracked_polished_purgatory_bricks"), new CrackedPolishedPurgatoryBricksBlock());
		CHISELED_POLISHED_PURGATORY_BRICKS = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "chiseled_polished_purgatory_bricks"), new ChiseledPolishedPurgatoryBricksBlock());
		GILDED_PURGATORY_STONE = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "gilded_purgatory_stone"), new GildedPurgatoryStoneBlock());
		IRON_INFUSED_PURGATORY_STONE = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "iron_infused_purgatory_stone"), new IronInfusedPurgatoryStoneBlock());
		POLISHED_PURGATORY_STONE_BRICK_WALL = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_brick_wall"), new PolishedPurgatoryStoneBrickWallBlock());
		POLISHED_PURGATORY_STONE_WALL = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_wall"), new PolishedPurgatoryStoneWallBlock());
		CRACKED_PURGATORY_STONE_BRICK_WALL = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "cracked_purgatory_stone_brick_wall"), new CrackedPurgatoryStoneBrickWallBlock());
		PURGATORY_STONE_SLAB = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "purgatory_stone_slab"), new PurgatoryStoneSlabBlock());
		POLISHED_PURGATORY_STONE_SLAB = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_slab"), new PolishedPurgatoryStoneSlabBlock());
		POLISHED_PURGATORY_STONE_BRICK_SLAB = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_brick_slab"), new PolishedPurgatoryStoneBrickSlabBlock());
		CRACKED_POLISHED_PURGATORY_BRICK_SLAB = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "cracked_polished_purgatory_brick_slab"), new CrackedPolishedPurgatoryBrickSlabBlock());
		PURGATORY_STONE_STAIRS = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "purgatory_stone_stairs"), new PurgatoryStoneStairsBlock());
		POLISHED_PURGATORY_STONE_STAIRS = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_stairs"), new PolishedPurgatoryStoneStairsBlock());
		POLISHED_PURGATORY_STONE_BRICK_STAIRS = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_stone_brick_stairs"), new PolishedPurgatoryStoneBrickStairsBlock());
		CRACKED_POLISHED_PURGATORY_STONE_STAIRS = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "cracked_polished_purgatory_stone_stairs"), new CrackedPolishedPurgatoryStoneStairsBlock());
		GILDED_PURGATORY_STONE_SLAB = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "gilded_purgatory_stone_slab"), new GildedPurgatoryStoneSlabBlock());
		IRON_INFUSED_PURGATORY_STONE_SLAB = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "iron_infused_purgatory_stone_slab"), new IronInfusedPurgatoryStoneSlabBlock());
		POLISHED_PURGATORY_FENCE = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "polished_purgatory_fence"), new PolishedPurgatoryFenceBlock());
		BLEEDING_OBSIDAN = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "bleeding_obsidan"), new BleedingObsidanBlock());
		DEMENANITE_ORE = Registry.register(Registry.BLOCK, new ResourceLocation(GildedDoomMod.MODID, "demenanite_ore"), new DemenaniteOreBlock());
	}

	public static void clientLoad() {
		PurgatoryNyliumBlock.clientInit();
		PurgatoryStoneBlock.clientInit();
		PolishedPurgatoryStoneBlock.clientInit();
		PolishedPurgatoryStoneBricksBlock.clientInit();
		CrackedPolishedPurgatoryBricksBlock.clientInit();
		ChiseledPolishedPurgatoryBricksBlock.clientInit();
		GildedPurgatoryStoneBlock.clientInit();
		IronInfusedPurgatoryStoneBlock.clientInit();
		PolishedPurgatoryStoneBrickWallBlock.clientInit();
		PolishedPurgatoryStoneWallBlock.clientInit();
		CrackedPurgatoryStoneBrickWallBlock.clientInit();
		PurgatoryStoneSlabBlock.clientInit();
		PolishedPurgatoryStoneSlabBlock.clientInit();
		PolishedPurgatoryStoneBrickSlabBlock.clientInit();
		CrackedPolishedPurgatoryBrickSlabBlock.clientInit();
		PurgatoryStoneStairsBlock.clientInit();
		PolishedPurgatoryStoneStairsBlock.clientInit();
		PolishedPurgatoryStoneBrickStairsBlock.clientInit();
		CrackedPolishedPurgatoryStoneStairsBlock.clientInit();
		GildedPurgatoryStoneSlabBlock.clientInit();
		IronInfusedPurgatoryStoneSlabBlock.clientInit();
		PolishedPurgatoryFenceBlock.clientInit();
		BleedingObsidanBlock.clientInit();
		DemenaniteOreBlock.clientInit();
	}
}
