package net.willywonks.gridcraftreuploaded.component;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister.DataComponents REGISTRAR =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, GridCraftReuploaded.MODID);

    public static final Supplier<DataComponentType<Integer>> DISK_COLOR = REGISTRAR.registerComponentType(
            "disk_color",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent(Codec.INT)
    );

    public static final Supplier<DataComponentType<Boolean>> DISK_ACTIVE = REGISTRAR.registerComponentType(
            "disk_active",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent(Codec.BOOL)
    );


    public static void register(IEventBus eventBus){
        REGISTRAR.register(eventBus);
    }
}

