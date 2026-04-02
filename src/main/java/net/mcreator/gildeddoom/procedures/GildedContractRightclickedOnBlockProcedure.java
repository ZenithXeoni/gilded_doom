package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.gildeddoom.init.GildedDoomModSounds;
import net.mcreator.gildeddoom.init.GildedDoomModMobEffects;
import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.Map;

public class GildedContractRightclickedOnBlockProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency world for procedure GildedContractRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency x for procedure GildedContractRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency y for procedure GildedContractRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency z for procedure GildedContractRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure GildedContractRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency itemstack for procedure GildedContractRightclickedOnBlock!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (!itemstack.getOrCreateTag().getBoolean("SoulPresent") && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(GildedDoomModMobEffects.GILDED_EMPOWERMENT) : false) && entity.isShiftKeyDown()) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
			if ((itemstack.getOrCreateTag().getString("MessageSoul")).equals(entity.getScoreboardName()) && itemstack.getOrCreateTag().getBoolean("UPMessageGiven")) {
				itemstack.getOrCreateTag().putString("PlayerSoul", entity.getScoreboardName());
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), SoundEvents.BOOK_PAGE_TURN, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.BOOK_PAGE_TURN, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) > 2) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					itemstack.getOrCreateTag().putBoolean("SoulPresent", true);
					itemstack.getOrCreateTag().putBoolean("BanBlocked", true);
					itemstack.getOrCreateTag().putBoolean("KillBlocked", true);
					itemstack.getOrCreateTag().putBoolean("ReturnBlocked", true);
					itemstack.getOrCreateTag().putInt("CustomModelData", 2);
					itemstack.getOrCreateTag().putBoolean("CustomSoul", true);
					itemstack.getOrCreateTag().putBoolean("SoulLocked", true);
					itemstack.getOrCreateTag().putString("LockedBy", "Myzkelon.");
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), GildedDoomModSounds.ULTIMATE_POWER_CHARGE_UP, SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, GildedDoomModSounds.ULTIMATE_POWER_CHARGE_UP, SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "particle endermanoverhaul:soul_fire ~ ~1.5 ~ 0 0 0 1 100 normal");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "particle minecraft:enchant ~ ~2.5 ~ 1 1 1 3 100 force");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "particle minecraft:block gilded_blackstone ~ ~2 ~ .5 .5 .5 2 100 normal");
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(GildedDoomModMobEffects.GILDED_STASIS, 60, 0));
					new Object() {
						private int ticks = 0;

						public void startDelay(LevelAccessor world) {
							ServerTickEvents.END_SERVER_TICK.register((server) -> {
								this.ticks++;
								if (this.ticks == 60) {
									{
										Entity _ent = entity;
										if (!_ent.level.isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
													"playsound minecraft:block.end_portal.spawn player @a");
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level.isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
													"particle minecraft:soul_fire_flame ~ ~1.5 ~ 0 0 0 0.5 100 force");
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level.isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands()
													.performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
																	_ent.getDisplayName(), _ent.level.getServer(), _ent),
															("set_max_health " + entity.getScoreboardName() + " " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) - 2)));
										}
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.getLevel().getScoreboard();
										Objective _so = _sc.getObjective("user_has_ultimate_power");
										if (_so == null)
											_so = _sc.addObjective("user_has_ultimate_power", ObjectiveCriteria.DUMMY, Component.literal("user_has_ultimate_power"), ObjectiveCriteria.RenderType.INTEGER);
										_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.getLevel().getScoreboard();
										Objective _so = _sc.getObjective("ObjectiveComplete");
										if (_so == null)
											_so = _sc.addObjective("ObjectiveComplete", ObjectiveCriteria.DUMMY, Component.literal("ObjectiveComplete"), ObjectiveCriteria.RenderType.INTEGER);
										_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
									}
									if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
										_entity.addEffect(new MobEffectInstance(GildedDoomModMobEffects.ULTIMATE_POWER, 60, 0));
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal("\u00A76\u00A7oHow to use Gilded Banishment"), false);
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal("\u00A76\u00A7o--"), false);
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal(
												"\u00A76\u00A7oYou must first have a Gilded Banisher. Once you have that item, hitting someone has a 25% chance to inflict Death\u2019s Mark. When someone is under Death\u2019s Mark, and they get hit with your gilded banisher at 3.5 Hearts or lower, they will receive Pending Death. "),
												false);
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal("\u00A76\u00A7o--"), false);
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal(
												"\u00A76\u00A7oOnce Pending Death is applied, your objective will be marked as complete. Pending Death will either go off after time, or go off as soon as they get killed, so watch out for the bomb that comes after you kill them."),
												false);
									return;
								}
							});
						}
					}.startDelay(world);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("You do not have the health for this."), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A76\u00A7oThose who seek ultimate power shall let a part of their life be taken from this book(1 Heart)."), false);
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A76\u00A7o--"), false);
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(
							"\u00A76\u00A7oUpon signature, you will be tasked to kill someone with Pending Death without dying once after signing this contract. If you end up dying, you will have a curse inflicted upon you - increasing with each death, with a max of 3, dying on max curse results in 7 day bans."),
							false);
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A76\u00A7o--"), false);
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(
							"\u00A76\u00A7oAfter you complete your objective, this contract shall remain active. You will remain capable of wielding your unlocked power. If your Greed remains Unsatiated, come back to me for even more power."),
							false);
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A77\u00A7o--A copy your Soul will be engraved, but it not be able to kill, ban, or return"), false);
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cCrouch Interact to sign."), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), SoundEvents.BOOK_PAGE_TURN, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.BOOK_PAGE_TURN, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				itemstack.getOrCreateTag().putBoolean("UPMessageGiven", true);
				itemstack.getOrCreateTag().putString("MessageSoul", entity.getScoreboardName());
			}
		} else if (!itemstack.getOrCreateTag().getBoolean("SoulPresent")) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
			if ((itemstack.getOrCreateTag().getString("MessageSoul")).equals(entity.getScoreboardName()) && itemstack.getOrCreateTag().getBoolean("MessageGiven")) {
				itemstack.getOrCreateTag().putString("PlayerSoul", entity.getScoreboardName());
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), SoundEvents.BOOK_PAGE_TURN, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.BOOK_PAGE_TURN, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				itemstack.getOrCreateTag().putBoolean("SoulPresent", true);
				itemstack.getOrCreateTag().putBoolean("BanBlocked", true);
				itemstack.getOrCreateTag().putBoolean("ReturnBlocked", true);
				itemstack.getOrCreateTag().putBoolean("CustomSoul", true);
				itemstack.getOrCreateTag().putInt("CustomModelData", 1);
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("<???> By signing this contract you are aware that your soul will be controlled by this contract"), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), SoundEvents.BOOK_PAGE_TURN, SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.BOOK_PAGE_TURN, SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				itemstack.getOrCreateTag().putBoolean("MessageGiven", true);
				itemstack.getOrCreateTag().putString("MessageSoul", entity.getScoreboardName());
			}
		} else if (itemstack.getOrCreateTag().getBoolean("SoulPresent") && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(GildedDoomModMobEffects.GILDED_EMPOWERMENT) : false) && entity.isShiftKeyDown()) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cYou must use an Empty Contract"), false);
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("Contracted Soul: " + itemstack.getOrCreateTag().getString("PlayerSoul"))), true);
		}
	}
}
