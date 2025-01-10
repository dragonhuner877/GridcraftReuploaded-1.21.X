package net.willywonks.gridcraftreuploaded.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.willywonks.gridcraftreuploaded.entity.custom.DiskProjectileEntity;

public class DiskThrownRenderer extends EntityRenderer<DiskProjectileEntity, DiskEntityRenderState> {
    private DiskThrownModel model;

    public DiskThrownRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new DiskThrownModel(context.bakeLayer(DiskThrownModel.LAYER_LOCATION));
    }

    @Override
    public DiskEntityRenderState createRenderState() {
        return null;
    }


}
