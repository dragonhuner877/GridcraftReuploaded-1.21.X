package net.willywonks.gridcraftreuploaded.item;

import net.minecraft.client.resources.model.EquipmentModelSet;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.equipment.EquipmentModel;
import net.minecraft.world.item.equipment.EquipmentModels;
import net.minecraft.world.item.equipment.Equippable;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;
import net.willywonks.gridcraftreuploaded.component.ModDataComponents;
import net.willywonks.gridcraftreuploaded.item.custom.IdentityDiskItem;

import java.util.Optional;

import static net.minecraft.core.component.DataComponents.DYED_COLOR;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GridCraftReuploaded.MODID);

    public static final DeferredItem<Item> IDENTITYDISK = ITEMS.registerItem(
            "iddisk",
            p -> new IdentityDiskItem(p
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)
                    .component(ModDataComponents.DISK_ACTIVE.get(), true)));

    public static final DeferredItem<Item> BASEHELMET = ITEMS.registerSimpleItem(
            "basehelm",
            new Item.Properties().component(
                    DataComponents.EQUIPPABLE,
                    Equippable.builder(EquipmentSlot.HEAD)
                            .setModel(ResourceLocation.fromNamespaceAndPath("gridcraftreuploaded", "basehelm"))
                            .setDamageOnHurt(false)
                            .build()
            ).component(DataComponents.DYED_COLOR, new DyedItemColor(0xFF03DBFC, true))

    );

    public static final DeferredItem<Item> BASECHEST = ITEMS.registerSimpleItem(
            "basechest",
            new Item.Properties().component(
                    DataComponents.EQUIPPABLE,
                    Equippable.builder(EquipmentSlot.CHEST)
                            .setModel(ResourceLocation.fromNamespaceAndPath("gridcraftreuploaded", "basechest"))
                            .setDamageOnHurt(false)
                            .build()
            ).component(DataComponents.DYED_COLOR, new DyedItemColor(0xFF03DBFC, true))

    );

    public static final DeferredItem<Item> BASELEGS = ITEMS.registerSimpleItem(
            "baselegs",
            new Item.Properties().component(
                    DataComponents.EQUIPPABLE,
                    Equippable.builder(EquipmentSlot.LEGS)
                            .setModel(ResourceLocation.fromNamespaceAndPath("gridcraftreuploaded", "baselegs"))
                            //.setModel(EquipmentModel.Dyeable())
                            .setDamageOnHurt(false)
                            .build()
            ).component(DYED_COLOR, new DyedItemColor(0xFF03DBFC,false))
    );

    public static final DeferredItem<Item> BASEBOOTS = ITEMS.registerSimpleItem(
            "baseboots",
            new Item.Properties().component(
                    DataComponents.EQUIPPABLE,
                    Equippable.builder(EquipmentSlot.FEET)
                            .setModel(ResourceLocation.fromNamespaceAndPath("gridcraftreuploaded", "baseboots"))
                            .setDamageOnHurt(false)
                            .build()
            ).component(DYED_COLOR, new DyedItemColor(0xFF03DBFC,false))

    );

    public static int getItemSlot(Player player, Item item){
        int itemSlot = -1;
        for(int i = 0; i < 54; i++){
            ItemStack currentItem = player.getInventory().getItem(i);
            if(currentItem.is(item)){
                return i;
            }
        }

        return itemSlot;
    }



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
