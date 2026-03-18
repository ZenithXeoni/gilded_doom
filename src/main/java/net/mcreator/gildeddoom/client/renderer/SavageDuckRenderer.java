package net.mcreator.gildeddoom.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.ChickenModel;

import net.mcreator.gildeddoom.entity.SavageDuckEntity;

public class SavageDuckRenderer extends MobRenderer<SavageDuckEntity, ChickenModel<SavageDuckEntity>> {
	public SavageDuckRenderer(EntityRendererProvider.Context context) {
		super(context, new ChickenModel(context.bakeLayer(ModelLayers.CHICKEN)), 0.5f);
		this.addLayer(new EyesLayer<SavageDuckEntity, ChickenModel<SavageDuckEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("gilded_doom:textures/entities/savage_duck.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SavageDuckEntity entity) {
		return new ResourceLocation("gilded_doom:textures/entities/savage_duck.png");
	}
}
