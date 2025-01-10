package net.willywonks.gridcraftreuploaded.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.willywonks.gridcraftreuploaded.block.ColorPickerBlockEntity;
import net.willywonks.gridcraftreuploaded.component.ModDataComponents;
import net.willywonks.gridcraftreuploaded.gui.ColorPickerGui;
import net.willywonks.gridcraftreuploaded.item.ModItems;

import javax.annotation.Nullable;

public class ColorPickerBlock extends HorizontalDirectionalBlock {
    private static final Component CONTAINER_TITLE = Component.translatable("container.colorpicker.color_picker");
    public static final MapCodec<ColorPickerBlock> CODEC = simpleCodec(ColorPickerBlock::new);
    public ColorPickerBlock(Properties properties) {
        super(properties);

    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player pPlayer, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            pPlayer.openMenu(new SimpleMenuProvider(
                    (containerId, playerInventory, player) -> new ColorPickerGui(containerId, playerInventory,ContainerLevelAccess.create(level, pos)),
                    Component.translatable("menu.title.gridcraftreuploaded.color_picker")
            ));
        }
        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider(
                (id, pInventory, player) -> new ColorPickerGui(id, pInventory), CONTAINER_TITLE
        );
    }
}
