
package net.mcreator.gildeddoom.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.gildeddoom.procedures.GildedContractRightclickedOnBlockProcedure;
import net.mcreator.gildeddoom.init.GildedDoomModTabs;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.List;

public class BookOfDocumentationItem extends PickaxeItem {
	public BookOfDocumentationItem() {
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
				return Ingredient.of(new ItemStack(Items.BOOK));
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

	@Override
	@Environment(EnvType.CLIENT)
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Hold this with an Item in your offhand"));
		list.add(Component.literal("If it\u2019s related to Gilded Banishment"));
		list.add(Component.literal("It will show you how it\u2019s used."));
	}
}
