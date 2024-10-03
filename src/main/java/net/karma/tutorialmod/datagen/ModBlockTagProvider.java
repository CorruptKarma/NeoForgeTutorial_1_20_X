package net.karma.tutorialmod.datagen;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.block.ModBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlock.VOID_CRYSTAL_BLOCK.get())
                .add(ModBlock.VOID_GEODE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlock.VOID_GEODE.get());
    }
}
