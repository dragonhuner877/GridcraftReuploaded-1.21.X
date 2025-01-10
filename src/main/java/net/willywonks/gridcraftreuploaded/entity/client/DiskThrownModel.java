package net.willywonks.gridcraftreuploaded.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;
import net.willywonks.gridcraftreuploaded.entity.custom.DiskProjectileEntity;

public class DiskThrownModel<DiskProjectileEntity> extends EntityModel {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(GridCraftReuploaded.MODID, "throwndiskentity"), "main");
    private final ModelPart BaseCubes;
    private final ModelPart OuterCurve;
    private final ModelPart bone;
    private final ModelPart InnerCurve;
    private final ModelPart TopU;

    public DiskThrownModel(ModelPart root) {
        super(root);
        this.BaseCubes = root.getChild("BaseCubes");
        this.OuterCurve = root.getChild("OuterCurve");
        this.bone = this.OuterCurve.getChild("bone");
        this.InnerCurve = root.getChild("InnerCurve");
        this.TopU = root.getChild("TopU");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition BaseCubes = partdefinition.addOrReplaceChild("BaseCubes", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 5.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.003F))
                .texOffs(0, 14).addBox(3.0F, -1.0F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(3.0F, -1.0F, 10.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -1.0F, 3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(10.0F, -1.0F, 3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(10, 34).addBox(11.0F, -1.0F, 9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.0001F))
                .texOffs(34, 10).addBox(-1.0F, -1.0F, 9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.0001F))
                .texOffs(34, 13).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.0001F))
                .texOffs(18, 35).addBox(11.0F, -1.0F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.0001F))
                .texOffs(26, 36).addBox(9.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.0001F))
                .texOffs(34, 36).addBox(1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.0001F))
                .texOffs(0, 37).addBox(1.0F, -1.0F, 11.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.0001F))
                .texOffs(8, 37).addBox(9.0F, -1.0F, 11.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.0001F)), PartPose.offset(-14.0F, 24.0F, 2.0F));

        PartDefinition cube_r1 = BaseCubes.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -1.0F, 0.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.003F)), PartPose.offsetAndRotation(7.0F, 0.0F, 7.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition OuterCurve = partdefinition.addOrReplaceChild("OuterCurve", CubeListBuilder.create(), PartPose.offset(-14.174F, 24.0F, 2.7987F));

        PartDefinition cube_r2 = OuterCurve.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(42, 42).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r3 = OuterCurve.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 42).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.9727F, 0.0F, -0.9727F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r4 = OuterCurve.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(22, 42).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(11.3753F, 0.0F, 11.3753F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r5 = OuterCurve.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(14, 7).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(12.3479F, 0.0F, 10.4026F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r6 = OuterCurve.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 16).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(2.4414F, 0.0F, -1.9541F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r7 = OuterCurve.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(14, 11).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(9.9065F, 0.0F, 12.3567F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r8 = OuterCurve.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(6, 24).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(-0.9814F, 0.0F, 1.4688F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r9 = OuterCurve.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(13.3293F, 0.0F, 8.9339F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r10 = OuterCurve.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 26).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(2.4414F, 0.0F, 12.3567F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r11 = OuterCurve.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(16, 21).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(9.9065F, 0.0F, -1.9541F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r12 = OuterCurve.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 7).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(-0.9814F, 0.0F, 8.9339F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r13 = OuterCurve.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(13.3293F, 0.0F, 1.4688F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r14 = OuterCurve.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(10, 43).addBox(-0.5F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.4026F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r15 = OuterCurve.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 43).addBox(-0.5F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.9727F, 0.0F, 11.3753F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r16 = OuterCurve.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(42, 36).addBox(-2.5F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(11.3753F, 0.0F, -0.9727F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r17 = OuterCurve.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(14, 3).addBox(-2.5F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(12.3479F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone = OuterCurve.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition InnerCurve = partdefinition.addOrReplaceChild("InnerCurve", CubeListBuilder.create().texOffs(30, 21).addBox(7.0607F, -1.0F, 1.6464F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(30, 26).addBox(-1.9393F, -1.0F, 1.6464F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(28, 3).addBox(1.0607F, -1.0F, -1.3536F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 0).addBox(1.0607F, -1.0F, 7.6464F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0607F, 24.0F, 4.3536F));

        PartDefinition cube_r18 = InnerCurve.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(38, 2).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r19 = InnerCurve.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(36, 31).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5858F, 0.0F, 0.5858F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r20 = InnerCurve.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1213F, 0.0F, 7.2929F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r21 = InnerCurve.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(28, 31).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7071F, 0.0F, 6.7071F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r22 = InnerCurve.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(20, 31).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.2929F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r23 = InnerCurve.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(6, 29).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5858F, 0.0F, 6.7071F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r24 = InnerCurve.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(26, 16).addBox(-0.5F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7071F, 0.0F, 0.5858F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r25 = InnerCurve.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(40, 25).addBox(-0.5F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1213F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition TopU = partdefinition.addOrReplaceChild("TopU", CubeListBuilder.create().texOffs(16, 19).addBox(1.0607F, -1.0F, 0.7678F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 5).addBox(-1.9393F, -1.0F, -7.2322F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(40, 16).addBox(9.0607F, -1.0F, -7.2322F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0607F, 23.9F, 12.2322F));

        PartDefinition cube_r26 = TopU.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(30, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r27 = TopU.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(20, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1716F, 0.0F, -0.1716F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r28 = TopU.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(10, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1716F, 0.0F, -8.2929F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r29 = TopU.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(46, 0).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.2929F, 0.0F, -8.2929F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r30 = TopU.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.2929F, 0.0F, -0.1716F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r31 = TopU.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(42, 28).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1213F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}
