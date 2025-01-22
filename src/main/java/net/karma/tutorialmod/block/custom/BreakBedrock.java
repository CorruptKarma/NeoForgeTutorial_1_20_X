package net.karma.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BreakBedrock extends Block {
    public BreakBedrock(Properties properties) {
        super(properties);
    }

    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        ItemStack heldItem = player.getMainHandItem();

        if(heldItem.is(Items.NETHERITE_PICKAXE)){
            return super.getDestroyProgress(state, player, level, pos);
        } else {
            return super.getDestroyProgress(state,player,level,pos) * -1f;
        }
    }

}
