package net.willywonks.gridcraftreuploaded.event;

import ca.weblite.objc.Client;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.block.entity.vault.VaultBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.util.Lazy;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;
import net.willywonks.gridcraftreuploaded.component.ModDataComponents;
import net.willywonks.gridcraftreuploaded.entity.client.DiskThrownModel;
import net.willywonks.gridcraftreuploaded.init.MenuTypes;
import net.willywonks.gridcraftreuploaded.item.ModItems;
import net.willywonks.gridcraftreuploaded.item.custom.IdentityDiskItem;
import org.lwjgl.glfw.GLFW;

import static net.willywonks.gridcraftreuploaded.item.ModItems.*;

@EventBusSubscriber(modid = GridCraftReuploaded.MODID, bus = EventBusSubscriber.Bus.MOD )
public class GameEvents {
       public static final Lazy<KeyMapping> ACTIVATE_DISK_MAPPING = Lazy.of(() ->new KeyMapping(
               "key.gridcraftreuploaded.activateitemkey", // Will be localized using this translation key
               InputConstants.Type.KEYSYM, // Default mapping is on the keyboard
               GLFW.GLFW_KEY_Z, // Default key is P
               "key.categories.gridcraftreuploaded.gridcraft"  // Mapping will be in the misc category
       ));
       @SubscribeEvent
       public static void registerBindings(RegisterKeyMappingsEvent event) {
           event.register(ACTIVATE_DISK_MAPPING.get());

    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
           event.registerLayerDefinition(DiskThrownModel.LAYER_LOCATION, DiskThrownModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void updateDiskColor(RegisterColorHandlersEvent.Item event){

        event.register((stack, tintIndex) -> {
            if(tintIndex == 0 && stack.getOrDefault(ModDataComponents.DISK_ACTIVE,true)) {//if disk is active, tint is the stored value, default white
                return stack.getOrDefault(ModDataComponents.DISK_COLOR, 0xFFFFFFFF);
            } else if (tintIndex == 0 && !stack.getOrDefault(ModDataComponents.DISK_ACTIVE,true)){//if disk is deactive, tint is black
                return 0xFF000000;
            }
            return 0xffffffff;//default value of white
        },
        IDENTITYDISK.get());

    }

  @SubscribeEvent
    public static void updateGridItemColor(RegisterColorHandlersEvent.Item event){
        event.register((stack, tintIndex) -> {
                    Player player = Minecraft.getInstance().player;
                    int diskSlot = IdentityDiskItem.playerHasDisk(player);
                    if (diskSlot > -1 ) {//checking for disk
                        ItemStack disk = player.getInventory().getItem(diskSlot);
                        if (tintIndex == 0 && disk.getOrDefault(ModDataComponents.DISK_ACTIVE, true)) {//if disk is active, tint is the stored value, default white
                            return disk.getOrDefault(ModDataComponents.DISK_COLOR, 0xFFFFFFFF);
                        } else if (tintIndex == 0 && !disk.getOrDefault(ModDataComponents.DISK_ACTIVE, true)) {//if disk is deactive, tint is black
                            return 0xFF000000;
                        }
                    }
                        return 0xffffffff;//default value of white

                },

                BASEHELMET.get(), BASECHEST.get(),BASELEGS.get(),BASEBOOTS.get());

    }
}
