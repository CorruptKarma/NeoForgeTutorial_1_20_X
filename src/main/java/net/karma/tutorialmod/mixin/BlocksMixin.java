package net.karma.tutorialmod.mixin;


import net.karma.tutorialmod.block.custom.BreakBedrock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Blocks.class)
public abstract class BlocksMixin {



    @Redirect(
            method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=bedrock")),
            at = @At(value = "NEW", target = "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;", ordinal = 0)
    )
    private static Block nemuelch$redirectBedrockBlockRegistration(BlockBehaviour.Properties properties) {
        return new BreakBedrock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .strength(1.0F, 3600000.0F)
                .isValidSpawn(Blocks::never));
    }
}
