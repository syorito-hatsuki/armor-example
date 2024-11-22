package dev.syoritohatsuki.armorexample.client.render.item;

import dev.syoritohatsuki.armorexample.ArmorExampleMod;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.Identifier;

public final class EndTridentItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0f, -1.0f, -1.0f);
        var tridentModel = new TridentEntityModel(TridentEntityModel.getTexturedModelData().createModel());
        tridentModel.render(
                matrices,
                ItemRenderer.getItemGlintConsumer(
                        vertexConsumers,
                        tridentModel.getLayer(Identifier.of(ArmorExampleMod.MOD_ID, "textures/entity/end_trident.png")),
                        false,
                        stack.hasGlint()
                ),
                light,
                overlay
        );
        matrices.pop();
    }

}
