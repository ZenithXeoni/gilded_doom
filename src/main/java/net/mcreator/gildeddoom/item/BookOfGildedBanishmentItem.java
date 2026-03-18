package net.mcreator.gildeddoom.item;

import net.mcreator.gildeddoom.init.GildedDoomModMobEffects;
import net.mcreator.gildeddoom.procedures.BookofGildedBanishmentItemInInventoryTickProcedure;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class BookOfGildedBanishmentItem extends PickaxeItem {
    public BookOfGildedBanishmentItem() {
        super(new Tier() {
            public int getUses() {
                return 250;
            }

            public float getSpeed() {
                return 4f;
            }

            public float getAttackDamageBonus() {
                return 2f;
            }

            public int getLevel() {
                return 4;
            }

            public int getEnchantmentValue() {
                return 25;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(Blocks.GILDED_BLACKSTONE));
            }
        }, 1, -2f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant());
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        BookofGildedBanishmentItemInInventoryTickProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder()
                .put("x", entity.getX()).put("y", entity.getY()).put("z", entity.getZ()).put("world", world).put("entity", entity).build());
    }

    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level;
        if (attacker instanceof Player player) {
            // 1. Check for Critical Hit conditions
            boolean isCrit = player.fallDistance > 0.0F && !player.isOnGround() && !player.onClimbable() 
                             && !player.isInWater() && !player.hasEffect(MobEffects.BLINDNESS) && !player.isPassenger();

            // 2. Check if the item is ready (Cooldown of 500 ticks = 25 seconds)
            if (isCrit && !player.getCooldowns().isOnCooldown(this)) {

                // Apply Gilded Stasis
                target.addEffect(new MobEffectInstance(GildedDoomModMobEffects.GILDED_STASIS, 100, 0));

                // Play Sound
                world.playSound(null, target.getX(), target.getY(), target.getZ(),
                        SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, SoundSource.PLAYERS, 1.0F, 0.5F);

                // Particles (Server-side check is handled inside world instanceof ServerLevel)
                if (world instanceof ServerLevel serverWorld) {
                    serverWorld.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.GILDED_BLACKSTONE.defaultBlockState()),
                            target.getX(), target.getY() + 1, target.getZ(), 20, 0.3, 0.3, 0.3, 0.15);
                }

                // 3. Trigger the 25-second cooldown
                player.getCooldowns().addCooldown(this, 500);
            }
        }
        return super.hurtEnemy(itemstack, target, attacker);
    }
}

