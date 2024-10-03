package net.karma.tutorialmod.block;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TutorialMod.MOD_ID);


    public static final DeferredBlock<Block> VOID_GEODE = registerBlock("void_geode",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.0F, 28125.0F).isValidSpawn(Blocks::never).sound(SoundType.CALCITE)));
    public static final DeferredBlock<Block> VOID_CRYSTAL_BLOCK = registerBlock("void_crystal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.0F, 28125.0F).isValidSpawn(Blocks::never).sound(SoundType.AMETHYST)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void  registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
