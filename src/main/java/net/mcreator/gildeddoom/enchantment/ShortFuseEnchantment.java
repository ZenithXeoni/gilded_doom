
package net.mcreator.gildeddoom.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.gildeddoom.init.GildedDoomModItems;

public class ShortFuseEnchantment extends Enchantment {
	public ShortFuseEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public boolean canEnchant(ItemStack stack) {
		if (stack.getItem() == GildedDoomModItems.GILDED_BANISHER)
			return true;
		return false;
	}
}
