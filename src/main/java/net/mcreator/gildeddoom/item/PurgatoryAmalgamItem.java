
package net.mcreator.gildeddoom.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.gildeddoom.procedures.PurgatoryAmalgamRightclickedRealProcedure;
import net.mcreator.gildeddoom.init.GildedDoomModTabs;

public class PurgatoryAmalgamItem extends Item {
	public PurgatoryAmalgamItem() {
		super(new Item.Properties().tab(GildedDoomModTabs.TAB_PURGATORY_TAB).stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getRecipeRemainder(ItemStack itemstack) {
		return new ItemStack(Items.ENDER_PEARL);
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		PurgatoryAmalgamRightclickedRealProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).put("itemstack", itemstack).build());
		return ar;
	}
}
