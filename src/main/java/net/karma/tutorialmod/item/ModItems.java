package net.karma.tutorialmod.item;

import net.karma.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> VOID_CRYSTAL = ITEMS.register("void_crystal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> VOID_AMETHYST = ITEMS.register("void_amethyst",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BEDROCK_DUST = ITEMS.register("bedrock_dust",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
