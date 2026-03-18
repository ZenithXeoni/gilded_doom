package net.mcreator.gildeddoom.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.gildeddoom.init.GildedDoomModItems;
import net.mcreator.gildeddoom.GildedDoomMod;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

import java.util.Map;
import java.util.HashMap;

public class NotrackingwhendeadProcedure {
	public NotrackingwhendeadProcedure() {
		ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", newPlayer.getX());
			dependencies.put("y", newPlayer.getY());
			dependencies.put("z", newPlayer.getZ());
			dependencies.put("world", newPlayer.level);
			dependencies.put("entity", newPlayer);
			dependencies.put("oldEntity", oldPlayer);
			execute(dependencies);
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GildedDoomMod.LOGGER.warn("Failed to load dependency entity for procedure Notrackingwhendead!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(GildedDoomModItems.TRACKING_TOME, 12000);
	}
}
