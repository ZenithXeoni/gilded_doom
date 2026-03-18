
package net.mcreator.gildeddoom.potion;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.gildeddoom.procedures.TheEchoFallExpirenceOnEffectActiveTickProcedure;

public class TheEchoFallExpirenceMobEffect extends MobEffect {
	public TheEchoFallExpirenceMobEffect() {
		super(MobEffectCategory.HARMFUL, -16751002);
	}

	@Override
	public String getDescriptionId() {
		return "effect.gilded_doom.the_echo_fall_experience";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		TheEchoFallExpirenceOnEffectActiveTickProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("x", x).put("y", y).put("z", z).put("entity", entity).build());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
