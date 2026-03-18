
package net.mcreator.gildeddoom.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.gildeddoom.init.GildedDoomModTabs;

public class GildedCoreItem extends Item {
	public GildedCoreItem() {
		super(new Item.Properties().tab(GildedDoomModTabs.TAB_GILDED_DOOM).stacksTo(4).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
