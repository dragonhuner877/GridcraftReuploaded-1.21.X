package net.willywonks.gridcraftreuploaded.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ItemAbility;
import net.willywonks.gridcraftreuploaded.component.ModDataComponents;
import net.willywonks.gridcraftreuploaded.entity.custom.DiskProjectileEntity;

import java.util.List;

import static net.willywonks.gridcraftreuploaded.item.ModItems.IDENTITYDISK;

public class IdentityDiskItem extends Item implements ProjectileItem {


    public IdentityDiskItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide) {
            DiskProjectileEntity idDiskProjectile = new DiskProjectileEntity(pPlayer, pLevel);
            idDiskProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 0F);
            pLevel.addFreshEntity(idDiskProjectile);
        }

        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.gridcraftreuploaded.iddisk1")
                    .append(Component.keybind("key.gridcraftreuploaded.activateitemkey")
                            ).append(Component.translatable("tooltip.gridcraftreuploaded.iddisk2")));
        }else {
            tooltipComponents.add(Component.translatable("tooltip.gridcraftreuploaded.iddiskcrouch"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public static int playerHasDisk(Player player){
        int diskSlot = -1;
        for(int i = 0; i < 54; i++){
            ItemStack item = player.getInventory().getItem(i);
            if(item.is(IDENTITYDISK)){
                return i;
            }
        }

        return diskSlot;
    }

    //not Functional
    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return super.canPerformAction(stack, ItemAbility.get("shield_block"));
    }


    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        return null;
    }
}
