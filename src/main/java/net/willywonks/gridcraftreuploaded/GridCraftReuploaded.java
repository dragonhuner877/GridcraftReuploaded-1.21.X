package net.willywonks.gridcraftreuploaded;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.willywonks.gridcraftreuploaded.block.ColorPickerBlockEntity;
import net.willywonks.gridcraftreuploaded.block.ModBlocks;
import net.willywonks.gridcraftreuploaded.component.ModDataComponents;
import net.willywonks.gridcraftreuploaded.entity.ModEntities;
import net.willywonks.gridcraftreuploaded.entity.client.DiskThrownRenderer;
import net.willywonks.gridcraftreuploaded.gui.ColorPickerGui;
import net.willywonks.gridcraftreuploaded.item.ModCreativeModeTabs;
import net.willywonks.gridcraftreuploaded.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import java.rmi.registry.Registry;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(GridCraftReuploaded.MODID)
public class GridCraftReuploaded {
    public static final String MODID = "gridcraftreuploaded";

    private static final Logger LOGGER = LogUtils.getLogger();

    private static GridCraftReuploaded instance;

    public static final DeferredRegister<MenuType<?>> REGISTER_MENUS = DeferredRegister.create(BuiltInRegistries.MENU, GridCraftReuploaded.MODID);
    public static GridCraftReuploaded get() { return instance; }
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public GridCraftReuploaded(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModDataComponents.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);



        ColorPickerBlockEntity.register(modEventBus);



        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        REGISTER_MENUS.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {

    }


    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.THROWN_DISK.get(), DiskThrownRenderer::new);
        }
    }
}
