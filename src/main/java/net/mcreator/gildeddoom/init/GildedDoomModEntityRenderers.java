
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gildeddoom.init;

import net.mcreator.gildeddoom.client.renderer.SavageDuckRenderer;
import net.mcreator.gildeddoom.client.renderer.DuckRenderer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class GildedDoomModEntityRenderers {
	public static void load() {
		EntityRendererRegistry.register(GildedDoomModEntities.DUCK, DuckRenderer::new);
		EntityRendererRegistry.register(GildedDoomModEntities.SAVAGE_DUCK, SavageDuckRenderer::new);
	}
}
