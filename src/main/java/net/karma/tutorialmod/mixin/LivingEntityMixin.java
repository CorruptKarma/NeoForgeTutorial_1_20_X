package net.karma.tutorialmod.mixin;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Unique
    private static final ResourceLocation GLASSES_C = ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "shaders/post/glasses.json");
    private LivingEntity self(){
        return (LivingEntity) (Object) this;
    }
    @Inject(method = "onEquipItem", at = @At("TAIL"))
    private void onEquipItem(EquipmentSlot slot, ItemStack oldStack, ItemStack newStack, CallbackInfo ci) {
        Minecraft client = Minecraft.getInstance();
        if (!self().level().isClientSide || slot != EquipmentSlot.HEAD) return;
        boolean firstPerson = client.options.getCameraType().isFirstPerson();
        if (!firstPerson || !newStack.is(ModItems.CREEPER_GLASSES.get())) {
            client.gameRenderer.shutdownEffect();
            return;
        }
        client.gameRenderer.loadEffect(GLASSES_C);
    }
}
