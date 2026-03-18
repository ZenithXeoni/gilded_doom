
package net.mcreator.gildeddoom.potion;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.gildeddoom.procedures.GildedStasisOnEffectActiveTickProcedure;

public class GildedStasisMobEffect extends MobEffect {
	public GildedStasisMobEffect() {
		super(MobEffectCategory.HARMFUL, -26368);
	}

	@Override
	public String getDescriptionId() {
		return "effect.gilded_doom.gilded_stasis";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		GildedStasisOnEffectActiveTickProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
