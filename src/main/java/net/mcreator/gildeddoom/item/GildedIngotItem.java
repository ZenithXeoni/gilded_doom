
package net.mcreator.gildeddoom.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.gildeddoom.init.GildedDoomModTabs;

public class GildedIngotItem extends Item {
	public GildedIngotItem() {
		super(new Item.Properties().tab(GildedDoomModTabs.TAB_GILDED_DOOM).stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
