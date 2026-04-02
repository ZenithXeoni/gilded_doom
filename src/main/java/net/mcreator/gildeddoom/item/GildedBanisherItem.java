
package net.mcreator.gildeddoom.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.gildeddoom.procedures.GildedBanisherRightclickedProcedure;
import net.mcreator.gildeddoom.procedures.GildedBanisherLivingEntityIsHitWithToolProcedure;
import net.mcreator.gildeddoom.init.GildedDoomModTabs;
import net.mcreator.gildeddoom.init.GildedDoomModItems;

public class GildedBanisherItem extends PickaxeItem {
	public GildedBanisherItem() {
		super(new Tier() {
			public int getUses() {
				return 2500;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 45;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT), new ItemStack(GildedDoomModItems.GILDED_INGOT));
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
		GildedBanisherLivingEntityIsHitWithToolProcedure
				.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).put("entity", entity).put("sourceentity", sourceentity).put("itemstack", itemstack).build());
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		GildedBanisherRightclickedProcedure
				.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("x", entity.getX()).put("y", entity.getY()).put("z", entity.getZ()).put("world", world).put("itemstack", ar.getObject()).build());
		return ar;
	}
}
