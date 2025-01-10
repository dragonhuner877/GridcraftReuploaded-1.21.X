package net.willywonks.gridcraftreuploaded.entity.custom;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
import net.willywonks.gridcraftreuploaded.item.ModItems;

import static net.willywonks.gridcraftreuploaded.entity.ModEntities.THROWN_DISK;

public class DiskProjectileEntity extends AbstractArrow {
    private float rotation;
    private int bounces;
    public Vec2 groundedOffset;
    public DiskProjectileEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public DiskProjectileEntity(LivingEntity shooter, Level level){
        super(THROWN_DISK.get(), shooter, level, new ItemStack(ModItems.IDENTITYDISK.get()), null);
        this.bounces = 0;
    }


    @Override
    protected ItemStack getDefaultPickupItem() {
        return null;
    }

    public float getRenderingRotation() {
        rotation +=.5;
        if(rotation >= 360){
            rotation = 0;
        }
        return rotation;
    }

    @Override
    protected boolean isInGround() {
        return super.isInGround();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 4);

        if(!this.level().isClientSide){
            this.level().broadcastEntityEvent(this,(byte)3);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if(bounces < 3){

            bounces++;
        }else{

        }
    }
}
