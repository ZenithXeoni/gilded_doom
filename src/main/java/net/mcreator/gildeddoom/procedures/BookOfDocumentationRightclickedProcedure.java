package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.gildeddoom.init.GildedDoomModItems;
import net.mcreator.gildeddoom.init.GildedDoomModBlocks;
import net.mcreator.gildeddoom.GildedDoomMod;

import java.util.Map;

public class BookOfDocumentationRightclickedProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure BookOfDocumentationRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.GILDED_BANISHER) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76How to use Pending Death."), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76--"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(
						"\u00A76You must first have a Gilded Banisher. Once you have that item, hitting someone has a 25% chance to inflict Death\u2019s Mark. When someone is under Death\u2019s Mark, and they get hit with your gilded banisher at 3.5 hearts or lower, they receive Pending Death."),
						false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76--"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76Once Pending Death is applied. Pending Death will either go off after time, or go off as soon as they get killed, so watch out for the bomb that comes after you kill them."),
						false);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.WARPED_AMALGAM) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(
						"\u00A76For Normal users, this Amalgam merely serves as a way to set your spawn remotely without using a bed (in overworld). but for those who have escaped purgatory not once, but twice, are granted the ability to hop between Death and Life."),
						false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76--"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(
						"\u00A76After you have unlocked [This Prison, to hold me?!], your interact feature is swapped to be what is dubbed \u201CPurgatory Warping\u201D. Before you warp into purgatory, it is recommended to set your return point beforehand by crouch interacting, as the scoreboard system responsible for your return will be null, sending you to absolute zero. Crouch Interacting also sets your respawn point there too."),
						false);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.CLEANSING_TOME) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7lThe Cleansing Tome, the ONLY way to escape Pending Death, made possible due to the collective mass of souls from the withers."), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76Death Curses"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76--"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76Deathcurse 1 = Weakness when attacked with a 25% chance"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76Deathcurse 2 = Weakness + Mining Fatigue when attacked with a 25% chance"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76Deathcurse 3 = Weakness + Mining Fatigue + Echofall Experience when attacked with a 25% chance"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76--"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76How to remove Death curses"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76--"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76Currently there is no cure obtainable, so whatever you are doing, must be worth it."), false);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.BOOK_OF_GILDED_BANISHMENT) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76Myzkelon"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76--"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76Classification: Dragonic Demon"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76Role: Curse Provider & Gilded Contract Enforcer"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76Status: Contained"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76All Known Abilities: Curse Creation, Extractive Consumption, Curse Detection, Contract Empowerment."), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cThreat: High"), false);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GildedDoomModBlocks.PURGATORY_STONE.asItem()) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(
						"\u00A74 Purgatory Stone, also known as Demonic Shungite, or Darkstone, is the main stone inside of hell. Darkstone consists mainly of Carbon, making it a perfect material for steel making inside of hell, making Hell Steel, Soul Steel, and Dragonic Steel possible. Darkstone can occasionally contain the essence of demonkind in the form of Abyssal essence, Demenanite, and \u201CDemon Eggs\u201D, which are the dormant state of Abyssal Demons. If a sinful lifeform dies on Demonic Shungite, the life essence will convert to Demenanite and if they were a demon, their soul will go underground inside of hell in the form of Abyssal essence."),
						false);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GildedDoomModBlocks.DEMENANITE_ORE.asItem()) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(
						Component.literal(
								"\u00A74Demenanite, the redstone of hell. Demenanite is one of the core components for most, if not all, inventions inside of hell. Demenanite was most commonly used in Hell Steel, Demon Orbs, and Soular Bombs."),
						false);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.GILDED_INGOT) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(
						"\u00A74Gilded Ingots, the Piglins attempt at creating Dragonic Steel. This Alloy contains very small traces of Dragonic power due to the Piglins' lowlife greed. Gilded Ingots are limited in set traits, whereas Dragonic Steel is limited to their wielder's Greedful Powers. Dragonics are able to chime into this alloy and channel power, but the power is limited by the material worth of the item."),
						false);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == GildedDoomModItems.PURGATORY_AMALGAM) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A74\u00A7lPurgatory"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A74\u00A7l--"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(
						"\u00A74Purgatory is alive. Using the core as their heart, redirecting most of its heat using the black shield (known in game as the bedrock layer) to keep themselves from burning up. Purgatory is responsible for handling all of the Abyssal Demons, the demons that come after their Sin-based life, choosing where they all go and making sure their soul isn\u2019t able to be accessed by them, making Purgatory be able to easily manipulate them. There are instances where Purgatory has taken control of Abyssals to deal with an issue, but most Abyssals work on their own instincts. Purgatory can also see into the future, even able to see when you read this text if you are in hell."),
						false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A74--"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(
						"\u00A74Purgatory both loves and hates demonkind, they love demonkind because they birthed demonkind, but they hate demonkind because they are very uncontrollable and keep harming Purgatory. This is why Purgatory has you fetch souls for them, to exterminate the devolved demons that infect them, ruining the land that Purgatory lives in."),
						false);
		}
	}
}
