
package net.mcreator.gildeddoom.potion;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.gildeddoom.procedures.PendingDeathEffectExpiresProcedure;

public class PendingDeathMobEffect extends MobEffect {
	public PendingDeathMobEffect() {
		super(MobEffectCategory.HARMFUL, -26368);
	}

	@Override
	public String getDescriptionId() {
		return "effect.gilded_doom.pending_death";
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		PendingDeathEffectExpiresProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).put("entity", entity).build());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
