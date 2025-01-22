package net.karma.tutorialmod.mixin;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

    private static final ResourceLocation GLASSES_C = ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,
            "shaders/post/glasses.json");

    @Inject(method = "checkEntityPostEffect", at = @At("TAIL"))
    private void loadShaderAgainIfWearingGlasses(Entity entity, CallbackInfo ci) {
        Minecraft client = Minecraft.getInstance();
        if (client.player == null) return;
        boolean firstPerson = client.options.getCameraType().isFirstPerson();
        ItemStack itemOnHead = client.player.getItemBySlot(EquipmentSlot.HEAD);
        if (firstPerson && itemOnHead.is(ModItems.CREEPER_GLASSES.get())) {
            client.gameRenderer.loadEffect(GLASSES_C);
        }
    }
}
