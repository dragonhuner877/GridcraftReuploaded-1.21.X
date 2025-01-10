package net.willywonks.gridcraftreuploaded.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.willywonks.gridcraftreuploaded.gui.ColorPickerGui;

import java.util.function.Supplier;

import static net.willywonks.gridcraftreuploaded.GridCraftReuploaded.MODID;

public class MenuTypes {

        public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, MODID);

        public static Supplier<MenuType<ColorPickerGui>> COLOR_PICKER_MENU = MENUS.register("color_picker_menu"
                , () -> new MenuType<>(ColorPickerGui::new, FeatureFlags.DEFAULT_FLAGS));

}
