package net.willywonks.gridcraftreuploaded.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;
import net.willywonks.gridcraftreuploaded.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GridCraftReuploaded.MODID);

    public static final Supplier<CreativeModeTab> GRIDCRAFT_MAIN_TAB = CREATIVE_MODE_TAB.register("gridcraft_main_tab",
            ()-> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.IDENTITYDISK.get()))
                    .title(Component.translatable("creativetab.gridcraftreuploaded.gridcraft_main"))
                    .displayItems((params, output) -> {
                      output.accept(ModItems.IDENTITYDISK.get());

                      output.accept(ModBlocks.RGB_PROGRAMMER.get().asItem());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
