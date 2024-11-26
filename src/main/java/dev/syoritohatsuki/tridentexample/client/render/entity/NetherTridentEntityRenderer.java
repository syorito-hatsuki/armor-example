package dev.syoritohatsuki.tridentexample.client.render.entity;

import dev.syoritohatsuki.tridentexample.TridentExampleMod;
import dev.syoritohatsuki.tridentexample.entity.NetherTridentEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.entity.state.TridentEntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class NetherTridentEntityRenderer extends EntityRenderer<NetherTridentEntity, TridentEntityRenderState> {

    public static final Identifier NETHER_TRIDENT_TEXTURE = Identifier.of(TridentExampleMod.MOD_ID, "textures/entity/nether_trident.png");

    private final TridentEntityModel model;

    public NetherTridentEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new TridentEntityModel(context.getPart(EntityModelLayers.TRIDENT));
    }

    public void render(TridentEntityRenderState tridentEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int glint) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(tridentEntityRenderState.yaw - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(tridentEntityRenderState.pitch + 90.0F));
        this.model.render(matrixStack, ItemRenderer.getItemGlintConsumer(
                vertexConsumerProvider,
                this.model.getLayer(NETHER_TRIDENT_TEXTURE),
                false,
                tridentEntityRenderState.enchanted
        ), glint, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(tridentEntityRenderState, matrixStack, vertexConsumerProvider, glint);
    }

    @Override
    public TridentEntityRenderState createRenderState() {
        return new TridentEntityRenderState();
    }

    public void updateRenderState(NetherTridentEntity endTridentEntity, TridentEntityRenderState tridentEntityRenderState, float tickDelta) {
        super.updateRenderState(endTridentEntity, tridentEntityRenderState, tickDelta);
        tridentEntityRenderState.yaw = endTridentEntity.getLerpedYaw(tickDelta);
        tridentEntityRenderState.pitch = endTridentEntity.getLerpedPitch(tickDelta);
        tridentEntityRenderState.enchanted = endTridentEntity.isEnchanted();
    }
}
