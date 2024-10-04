package net.karma.tutorialmod.item.client;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.item.custom.AnimatedItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedItemModel extends GeoModel<AnimatedItem> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "geo/crystal_scythe.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/item/crystal.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "animations/model.animation.json");

    @Override
    public ResourceLocation getModelResource(AnimatedItem animatable) { return this.model; }

    @Override
    public ResourceLocation getTextureResource(AnimatedItem animatable) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedItem animatable) {
        return this.animations;
    }
}
