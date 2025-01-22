package net.karma.tutorialmod.event;


import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import javax.management.ObjectName;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemEvent;

@EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value =  Dist.CLIENT)
public class ModClientEvents {


    @SubscribeEvent
    public static void BedrockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack MainHandItem = player.getMainHandItem();

        if (!(event.getPlayer() instanceof ServerPlayer serverPlayer)) {
            return;
        }
        if(serverPlayer.gameMode.getGameModeForPlayer() != GameType.SURVIVAL){
            return;
        }

        if(MainHandItem.getItem() == Items.NETHERITE_PICKAXE){
            BlockState blockState = event.getState();
            if (blockState.getBlock() == Blocks.BEDROCK) {
                BlockPos blockPos = event.getPos();
                GetCustomLoot(serverPlayer, blockPos, blockState);
            }
        }
    }

    private static void GetCustomLoot(ServerPlayer serverPlayer, BlockPos pos, BlockState state){
        ItemStack customLoot = new ItemStack((Holder<Item>) ModItems.BEDROCK_DUST, 3);
        ItemEntity itemEntity = new ItemEntity(serverPlayer.level(),
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5,
                customLoot);
        serverPlayer.level().addFreshEntity(itemEntity);
    }
}