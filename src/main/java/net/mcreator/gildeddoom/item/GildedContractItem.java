
package net.mcreator.gildeddoom.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.gildeddoom.procedures.GildedContractRightclickedOnBlockProcedure;
import net.mcreator.gildeddoom.init.GildedDoomModTabs;

public class GildedContractItem extends PickaxeItem {
	public GildedContractItem() {
		super(new Tier() {
			public int getUses() {
				return 100;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().tab(GildedDoomModTabs.TAB_GILDED_DOOM));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		GildedContractRightclickedOnBlockProcedure
				.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("x", entity.getX()).put("y", entity.getY()).put("z", entity.getZ()).put("world", world).put("entity", entity).put("itemstack", ar.getObject()).build());
		return ar;
	}
}
