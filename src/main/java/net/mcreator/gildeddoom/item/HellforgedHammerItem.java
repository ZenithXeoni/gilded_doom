
package net.mcreator.gildeddoom.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.gildeddoom.procedures.HellforgedHammerToolInHandTickProcedure;
import net.mcreator.gildeddoom.procedures.HellforgedHammerLivingEntityIsHitWithToolProcedure;
import net.mcreator.gildeddoom.init.GildedDoomModTabs;
import net.mcreator.gildeddoom.init.GildedDoomModItems;

public class HellforgedHammerItem extends PickaxeItem {
	public HellforgedHammerItem() {
		super(new Tier() {
			public int getUses() {
				return 2500;
			}

			public float getSpeed() {
				return 11f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 35;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(GildedDoomModItems.INFERNAL_SCRAP), new ItemStack(Items.NETHERITE_SCRAP));
			}
		}, 1, -3f, new Item.Properties().tab(GildedDoomModTabs.TAB_GILDED_DOOM).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		Level world = entity.level;
		HellforgedHammerLivingEntityIsHitWithToolProcedure
				.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).put("entity", entity).put("sourceentity", sourceentity).put("itemstack", itemstack).build());
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			HellforgedHammerToolInHandTickProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("x", entity.getX()).put("y", entity.getY()).put("z", entity.getZ()).put("world", world).build());
	}
}
