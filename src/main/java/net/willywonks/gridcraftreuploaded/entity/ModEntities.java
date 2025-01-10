package net.willywonks.gridcraftreuploaded.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.Arrow;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;
import net.willywonks.gridcraftreuploaded.entity.custom.DiskProjectileEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, GridCraftReuploaded.MODID);

    public static final Supplier<EntityType<DiskProjectileEntity>> THROWN_DISK =
            ENTITY_TYPES.register("thrown_disk",
                    () -> EntityType.Builder.<DiskProjectileEntity>of(DiskProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build(ResourceKey.create(Registries.ENTITY_TYPE,ResourceLocation.fromNamespaceAndPath(GridCraftReuploaded.MODID,"thrown_disk"))));



    public static void register (IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);

    }
}
