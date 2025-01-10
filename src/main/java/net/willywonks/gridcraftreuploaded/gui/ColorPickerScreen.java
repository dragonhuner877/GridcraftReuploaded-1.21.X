package net.willywonks.gridcraftreuploaded.gui;

import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.EnchantmentNames;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;

import java.util.List;
import java.util.Optional;

public class ColorPickerScreen extends AbstractContainerScreen<ColorPickerGui> {
//background sprite
    private static final ResourceLocation BACKGROUND_LOCATION = ResourceLocation.fromNamespaceAndPath(GridCraftReuploaded.MODID, "textures/gui/container/color_picker_screen.png");

    private ItemStack last = ItemStack.EMPTY;

    public ColorPickerScreen(ColorPickerGui menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }
    @Override
    //Used eventually to handle the screen interactions like the slider
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;

        for (int k = 0; k < 3; k++) {
            double d0 = mouseX - (double)(i + 60);
            double d1 = mouseY - (double)(j + 14 + 19 * k);
            if (d0 >= 0.0 && d1 >= 0.0 && d0 < 108.0 && d1 < 19.0 && this.menu.clickMenuButton(this.minecraft.player, k)) {
                this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, k);
                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }



    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(RenderType::guiTextured, BACKGROUND_LOCATION, i, j, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);

    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        float f = this.minecraft.getDeltaTracker().getGameTimeDeltaPartialTick(false);
        super.render(guiGraphics, mouseX, mouseY, f);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        boolean flag = this.minecraft.player.getAbilities().instabuild;

    }
}
