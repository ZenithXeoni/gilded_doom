
package net.mcreator.gildeddoom.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.gildeddoom.procedures.TrackingTomeRightclickedProcedure;
import net.mcreator.gildeddoom.init.GildedDoomModTabs;

public class TrackingTomeItem extends Item {
	public TrackingTomeItem() {
		super(new Item.Properties().tab(GildedDoomModTabs.TAB_GILDED_DOOM).stacksTo(64).rarity(Rarity.RARE));
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

		TrackingTomeRightclickedProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("y", y).put("entity", entity).put("itemstack", itemstack).build());
		return ar;
	}
}
