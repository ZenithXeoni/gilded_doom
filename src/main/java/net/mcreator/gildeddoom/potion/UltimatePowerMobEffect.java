
package net.mcreator.gildeddoom.potion;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.gildeddoom.procedures.UltimatePowerOnEffectActiveTickProcedure;

public class UltimatePowerMobEffect extends MobEffect {
	public UltimatePowerMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -256);
	}

	@Override
	public String getDescriptionId() {
		return "effect.gilded_doom.ultimate_power";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		UltimatePowerOnEffectActiveTickProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("entity", entity).build());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
