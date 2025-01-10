package net.willywonks.gridcraftreuploaded.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;
import net.willywonks.gridcraftreuploaded.component.ModDataComponents;

import java.util.Stack;

import static net.willywonks.gridcraftreuploaded.event.GameEvents.ACTIVATE_DISK_MAPPING;
import static net.willywonks.gridcraftreuploaded.item.ModItems.*;

@EventBusSubscriber(modid = GridCraftReuploaded.MODID, bus = EventBusSubscriber.Bus.GAME )
public class ClientGameEvents {
    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        while (ACTIVATE_DISK_MAPPING.get().consumeClick()) {
            Player player = Minecraft.getInstance().player;
            ItemStack disk = player.getMainHandItem();
            if(player.getMainHandItem().is(IDENTITYDISK) && !player.getMainHandItem().getOrDefault(ModDataComponents.DISK_ACTIVE, false)) {
                if(!player.hasItemInSlot(EquipmentSlot.HEAD)  && !player.hasItemInSlot(EquipmentSlot.CHEST)
                        && !player.hasItemInSlot(EquipmentSlot.LEGS) && !player.hasItemInSlot(EquipmentSlot.FEET)){
                    //player.sendSystemMessage(Component.literal("Activating Disk"));

                    player.getMainHandItem().set(ModDataComponents.DISK_ACTIVE, true);
                    player.setItemSlot(EquipmentSlot.HEAD, BASEHELMET.get().getDefaultInstance());
                    player.setItemSlot(EquipmentSlot.CHEST, BASECHEST.get().getDefaultInstance());
                    player.setItemSlot(EquipmentSlot.LEGS, BASELEGS.get().getDefaultInstance());
                    player.setItemSlot(EquipmentSlot.FEET, BASEBOOTS.get().getDefaultInstance());
                    player.getItemBySlot(EquipmentSlot.HEAD).set(DataComponents.DYED_COLOR, new DyedItemColor(disk.getOrDefault(ModDataComponents.DISK_COLOR, 0xFFFFFFFF),false));
                    player.getItemBySlot(EquipmentSlot.CHEST).set(DataComponents.DYED_COLOR, new DyedItemColor(disk.getOrDefault(ModDataComponents.DISK_COLOR, 0xFFFFFFFF),false));
                    player.getItemBySlot(EquipmentSlot.LEGS).set(DataComponents.DYED_COLOR, new DyedItemColor(disk.getOrDefault(ModDataComponents.DISK_COLOR, 0xFFFFFFFF),false));
                    player.getItemBySlot(EquipmentSlot.FEET).set(DataComponents.DYED_COLOR, new DyedItemColor(disk.getOrDefault(ModDataComponents.DISK_COLOR, 0xFFFFFFFF),false));
                }else {
                    //player.sendSystemMessage(Component.literal("Cannot Activate Disk, User is Wearing Armor"));
                }
            }else if (player.getMainHandItem().is(IDENTITYDISK) && player.getMainHandItem().getOrDefault(ModDataComponents.DISK_ACTIVE, false)){
                //player.sendSystemMessage(Component.literal("De-activating Disk"));
                player.getMainHandItem().set(ModDataComponents.DISK_ACTIVE, false);
                player.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                player.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
                player.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
                player.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
            }
        }
    }

}
