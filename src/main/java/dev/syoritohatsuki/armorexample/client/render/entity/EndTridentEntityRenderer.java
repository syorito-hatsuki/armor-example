package dev.syoritohatsuki.armorexample.client.render.entity;

import dev.syoritohatsuki.armorexample.ArmorExampleMod;
import dev.syoritohatsuki.armorexample.entity.EndTridentEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
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

public class EndTridentEntityRenderer extends EntityRenderer<EndTridentEntity, TridentEntityRenderState> {

    public static final Identifier TEXTURE = Identifier.of(ArmorExampleMod.MOD_ID, "textures/entity/end_trident.png");
    private final TridentEntityModel model;

    public EndTridentEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new TridentEntityModel(context.getPart(EntityModelLayers.TRIDENT));
    }

    public void render(TridentEntityRenderState tridentEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(tridentEntityRenderState.yaw - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(tridentEntityRenderState.pitch + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumerProvider, this.model.getLayer(TEXTURE), false, tridentEntityRenderState.enchanted
        );
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(tridentEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public TridentEntityRenderState createRenderState() {
        return new TridentEntityRenderState();
    }

    public void updateRenderState(EndTridentEntity endTridentEntity, TridentEntityRenderState tridentEntityRenderState, float f) {
        super.updateRenderState(endTridentEntity, tridentEntityRenderState, f);
        tridentEntityRenderState.yaw = endTridentEntity.getLerpedYaw(f);
        tridentEntityRenderState.pitch = endTridentEntity.getLerpedPitch(f);
        tridentEntityRenderState.enchanted = endTridentEntity.isEnchanted();
    }
}
