
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.gildeddoom.init;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;

public class GildedDoomModTrades {
	public static void registerTrades() {
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5, factories -> {
			factories.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.TOTEM_OF_UNDYING), new ItemStack(GildedDoomModItems.GILDED_CORE), 1, 20, 0.1f));
		});
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5, factories -> {
			factories.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Blocks.ANCIENT_DEBRIS, 4), new ItemStack(GildedDoomModItems.ANCIENT_HAMMER), 1, 20, 0.05f));
		});
	}

	private record BasicTrade(ItemStack price, ItemStack price2, ItemStack offer, int maxTrades, int xp, float priceMult) implements VillagerTrades.ItemListing {
		@Override
		public @NotNull MerchantOffer getOffer(Entity entity, RandomSource random) {
			return new MerchantOffer(price, price2, offer, maxTrades, xp, priceMult);
		}
	}
}
