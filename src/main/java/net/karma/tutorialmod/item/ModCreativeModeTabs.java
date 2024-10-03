package net.karma.tutorialmod.item;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.block.ModBlock;
import net.karma.tutorialmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> VOID_ITEMS_TAB = CREATIVE_MODE_TAB.register("void_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VOID_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.tutorialmod.void_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.VOID_CRYSTAL);
                        output.accept(ModItems.VOID_AMETHYST);
                        output.accept(ModItems.BEDROCK_DUST);
                    }).build());
    public static final Supplier<CreativeModeTab> VOID_BLOCKS_TAB = CREATIVE_MODE_TAB.register("void_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlock.VOID_GEODE.get()))
                    .title(Component.translatable("creativetab.tutorialmod.void_block"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlock.VOID_GEODE);
                        output.accept(ModBlock.VOID_CRYSTAL_BLOCK);
                    }).build());
 //spoky month
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
