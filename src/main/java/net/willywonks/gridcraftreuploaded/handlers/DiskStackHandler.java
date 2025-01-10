package net.willywonks.gridcraftreuploaded.handlers;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.willywonks.gridcraftreuploaded.block.ColorPickerBlockEntity;
import net.willywonks.gridcraftreuploaded.item.ModItems;

public class DiskStackHandler extends ItemStackHandler {

    public DiskStackHandler() {
        super(1);
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        if(stack.is(ModItems.IDENTITYDISK)){
            return true;
        }
        return false;
    }

    @Override
    protected void onContentsChanged(int slot)
    {
        super.onContentsChanged(slot);
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        return super.insertItem(slot, stack, simulate);
    }
}
