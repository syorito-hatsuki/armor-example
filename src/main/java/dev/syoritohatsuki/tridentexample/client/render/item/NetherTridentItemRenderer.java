package dev.syoritohatsuki.tridentexample.client.render.item;

import dev.syoritohatsuki.tridentexample.client.render.entity.NetherTridentEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;

public final class NetherTridentItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int glint, int overlay) {
        matrices.push();
        matrices.scale(1.0f, -1.0f, -1.0f);

        var tridentModel = new TridentEntityModel(TridentEntityModel.getTexturedModelData().createModel());
        tridentModel.render(matrices, ItemRenderer.getItemGlintConsumer(
                vertexConsumers,
                tridentModel.getLayer(NetherTridentEntityRenderer.NETHER_TRIDENT_TEXTURE),
                false,
                stack.hasGlint()
        ), glint, overlay);

        matrices.pop();
    }

}
