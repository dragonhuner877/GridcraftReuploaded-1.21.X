package net.willywonks.gridcraftreuploaded.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;
import net.willywonks.gridcraftreuploaded.block.custom.ColorPickerBlock;
import net.willywonks.gridcraftreuploaded.item.ModItems;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GridCraftReuploaded.MODID);


public static final DeferredBlock<ColorPickerBlock> RGB_PROGRAMMER =
        ModBlocks.registerBlockWithItem(
                "color_programmer",
                ColorPickerBlock::new,
                BlockBehaviour.Properties.of()
                        .strength(4.0F, 3.0F)
                        .setId(blockId("color_programmer"))
        );

    // Registers
    public static <T extends Block> DeferredBlock<T> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, T> blockCreator, BlockBehaviour.Properties properties) {
        DeferredBlock<T> block = BLOCKS.registerBlock(name, blockCreator, properties);
        ModItems.ITEMS.registerSimpleBlockItem(name, block);
        return block;
    }

    public static ResourceKey<Block> blockId(String name) {
        return ResourceKey.create(Registries.BLOCK, GridCraftReuploaded.rl(name));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);

    }


    /*
    public static ResourceKey<Item> itemId(String name) {
        return ResourceKey.create(Registries.ITEM, GridCraftReuploaded.rl(name));
    }

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> blockCreator) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, () -> blockCreator.apply(BlockBehaviour.Properties.of().setId(blockId(name))));
        registerBlockItems(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(itemId(name)).useBlockDescriptionPrefix()));
    } */
}
