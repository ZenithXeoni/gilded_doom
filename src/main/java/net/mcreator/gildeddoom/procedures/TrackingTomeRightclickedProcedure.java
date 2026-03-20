package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.gildeddoom.init.GildedDoomModMobEffects;
import net.mcreator.gildeddoom.init.GildedDoomModItems;
import net.mcreator.gildeddoom.GildedDoomMod;

import java.util.Map;
import java.util.ArrayList;

public class TrackingTomeRightclickedProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure TrackingTomeRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency y for procedure TrackingTomeRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure TrackingTomeRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency itemstack for procedure TrackingTomeRightclicked!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.TRACKING_TOME
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(GildedDoomModMobEffects.ULTIMATE_POWER) : false) || (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(GildedDoomModMobEffects.GILDED_EMPOWERMENT) : false)
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(GildedDoomModMobEffects.GILDED_IMMUNITY) : false)) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (!((entityiterator instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) : false) || (entityiterator instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.INVISIBILITY) : false)
						|| (entityiterator instanceof LivingEntity _livEnt ? _livEnt.hasEffect(GildedDoomModMobEffects.GILDED_IMMUNITY) : false)
						|| (entityiterator instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) : false))
						&& (entityiterator.getScoreboardName()).equals((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("PlayerSoul"))) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), y, (entityiterator.getZ())));
					if (entityiterator instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("You are being tracked."), true);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 3000);
					if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300, 1));
				}
			}
		}
	}
}
