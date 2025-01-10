package net.willywonks.gridcraftreuploaded.gui;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;
import net.willywonks.gridcraftreuploaded.block.ColorPickerBlockEntity;
import net.willywonks.gridcraftreuploaded.block.ModBlocks;
import net.willywonks.gridcraftreuploaded.handlers.DiskStackHandler;
import net.willywonks.gridcraftreuploaded.init.MenuTypes;
import net.willywonks.gridcraftreuploaded.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

import static net.willywonks.gridcraftreuploaded.block.ModBlocks.RGB_PROGRAMMER;

public class ColorPickerGui extends AbstractContainerMenu {
    public static final int INPUT_SLOT = 0;
    private final DataSlot color = DataSlot.standalone();
    private static final Component CONTAINER_TITLE = Component.translatable("container.colorpicker.color_picker");
    private final ItemStackHandler diskSlot;
    private final ContainerLevelAccess access;


    public ColorPickerGui(int pContainerId, Inventory inventory) {
        this(pContainerId, inventory, ContainerLevelAccess.NULL);
    }

    public ColorPickerGui(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(MenuTypes.COLOR_PICKER_MENU.get(), containerId);
        this.diskSlot = new DiskStackHandler();
        this.addDataSlot(this.color);
        Player player = playerInventory.player;
        this.addStandardInventorySlots(playerInventory, 8, 84);
        this.access = access;
        this.addSlot(new SlotItemHandler(this.diskSlot, 0, 15, 47) {
            public int getMaxStackSize() {
                return 1;
            }
        });
        this.addStandardInventorySlots(playerInventory, 8, 84);
        this.addDataSlot(this.color);//maybe issue

    }


    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot) this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (itemstack1.is(ModItems.IDENTITYDISK.get())) {
                if (!this.moveItemStackTo(itemstack1, 1, 2, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (((Slot) this.slots.get(0)).hasItem() || !((Slot) this.slots.get(0)).mayPlace(itemstack1)) {
                    return ItemStack.EMPTY;
                }

                ItemStack itemstack2 = itemstack1.copyWithCount(1);
                itemstack1.shrink(1);
                ((Slot) this.slots.get(0)).setByPlayer(itemstack2);
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }



    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, RGB_PROGRAMMER.get());
    }

}


