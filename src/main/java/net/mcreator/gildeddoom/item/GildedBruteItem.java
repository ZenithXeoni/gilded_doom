
package net.mcreator.gildeddoom.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;

import net.mcreator.gildeddoom.procedures.GildedBruteLeggingsTickEventProcedure;
import net.mcreator.gildeddoom.procedures.GildedBruteHelmetTickEventProcedure;
import net.mcreator.gildeddoom.init.GildedDoomModTabs;
import net.mcreator.gildeddoom.init.GildedDoomModItems;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.List;

public abstract class GildedBruteItem extends ArmorItem {
	public GildedBruteItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 40;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{3, 6, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 15;
			}

			@Override
			public SoundEvent getEquipSound() {
				return SoundEvents.ARMOR_EQUIP_NETHERITE;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(GildedDoomModItems.GILDED_INGOT), new ItemStack(Items.NETHERITE_INGOT));
			}

			@Environment(EnvType.CLIENT)
			@Override
			public String getName() {
				return "gilded_brute_armor_";
			}

			@Override
			public float getToughness() {
				return 3f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		}, slot, properties);
	}

	public static class Helmet extends GildedBruteItem {

		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(GildedDoomModTabs.TAB_GILDED_DOOM).fireResistant());
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slotinv, boolean selected) {
			double unique = Math.random();
			ItemStack stack = entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY;
			if (stack.getItem() == (itemstack).getItem()) {
				if (stack.getOrCreateTag().getDouble("_id") != unique)
					stack.getOrCreateTag().putDouble("_id", unique);
				if (itemstack.getOrCreateTag().getDouble("_id") == unique)
					GildedBruteHelmetTickEventProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
			}
		}
	}

	public static class Chestplate extends GildedBruteItem {

		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(GildedDoomModTabs.TAB_GILDED_DOOM).fireResistant());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("Built-in Thorns III~"));
		}
	}

	public static class Leggings extends GildedBruteItem {

		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(GildedDoomModTabs.TAB_GILDED_DOOM).fireResistant());
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slotinv, boolean selected) {
			double unique = Math.random();
			ItemStack stack = entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY;
			if (stack.getItem() == (itemstack).getItem()) {
				if (stack.getOrCreateTag().getDouble("_id") != unique)
					stack.getOrCreateTag().putDouble("_id", unique);
				if (itemstack.getOrCreateTag().getDouble("_id") == unique)
					GildedBruteLeggingsTickEventProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
			}
		}
	}

	public static class Boots extends GildedBruteItem {

		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(GildedDoomModTabs.TAB_GILDED_DOOM).fireResistant());
		}

	}
}
