
package net.mcreator.gildeddoom.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.gildeddoom.init.GildedDoomModItems;
import net.mcreator.gildeddoom.init.GildedDoomModEnchantments;

public class RarityEnchantment extends Enchantment {
	public RarityEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		if (ench == GildedDoomModEnchantments.TORRENT)
			return true;
		if (ench == GildedDoomModEnchantments.FORTITUDE)
			return true;
		if (ench == GildedDoomModEnchantments.KNOCKOUT)
			return true;
		return false;
	}

	@Override
	public boolean canEnchant(ItemStack stack) {
		if (stack.getItem() == GildedDoomModItems.ANCIENT_HAMMER)
			return true;
		if (stack.getItem() == GildedDoomModItems.IRON_HAMMER)
			return true;
		if (stack.getItem() == GildedDoomModItems.HELLFORGED_HAMMER)
			return true;
		if (stack.getItem() == GildedDoomModItems.SOULFORGED_HAMMER)
			return true;
		if (stack.getItem() == GildedDoomModItems.GILDED_BANISHER)
			return true;
		return false;
	}
}
