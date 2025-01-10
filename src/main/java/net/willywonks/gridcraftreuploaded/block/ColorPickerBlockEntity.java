package net.willywonks.gridcraftreuploaded.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;
import net.willywonks.gridcraftreuploaded.handlers.DiskStackHandler;

import java.util.function.Supplier;

public class ColorPickerBlockEntity extends BlockEntity {
    public static int storedColor = 0xFFFFFFFF;
    public static NonNullList<ItemStack> inventory;
    //public final DiskStackHandler storedDisk = new DiskStackHandler(this);
    public ColorPickerBlockEntity(BlockPos pos, BlockState blockState) {
        super(COLOR_PICKER_ENTITY.get(), pos, blockState);
    }
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, GridCraftReuploaded.MODID);
    public static final Supplier<BlockEntityType<ColorPickerBlockEntity>> COLOR_PICKER_ENTITY = BLOCK_ENTITY_TYPES.register(
            "color_picker_entity",
            // The block entity type.
            () -> new BlockEntityType<>(
                    // The supplier to use for constructing the block entity instances.
                    ColorPickerBlockEntity::new,
                    // A vararg of blocks that can have this block entity.
                    // This assumes the existence of the referenced blocks as DeferredBlock<Block>s.
                    ModBlocks.RGB_PROGRAMMER.get()
            )
    );

    public void markInputInventoryChanged()
    {
        this.setChanged();
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.storedColor = tag.getInt("storedColor");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("storedColor", this.storedColor);
        ContainerHelper.saveAllItems(tag, inventory,registries);
    }

    public static void register(IEventBus eventBus){
        BLOCK_ENTITY_TYPES.register(eventBus);

    }

    public static NonNullList<ItemStack> getInventory() {
        return inventory;
    }


}
