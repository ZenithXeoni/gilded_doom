
package net.mcreator.gildeddoom.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DeathsMarkMobEffect extends MobEffect {
	public DeathsMarkMobEffect() {
		super(MobEffectCategory.HARMFUL, -13312);
	}

	@Override
	public String getDescriptionId() {
		return "effect.gilded_doom.deaths_mark";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
