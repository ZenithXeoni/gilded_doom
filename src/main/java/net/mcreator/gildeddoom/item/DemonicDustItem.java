
package net.mcreator.gildeddoom.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.gildeddoom.init.GildedDoomModTabs;

public class DemonicDustItem extends Item {
	public DemonicDustItem() {
		super(new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB).stacksTo(16).rarity(Rarity.COMMON));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
