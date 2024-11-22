package dev.syoritohatsuki.armorexample.mixin.client;

import dev.syoritohatsuki.armorexample.client.render.item.EndTridentItemRenderer;
import dev.syoritohatsuki.armorexample.registry.ItemsRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltinModelItemRenderer.class)
public abstract class BuiltinModelItemRendererMixin {
    @Inject(method = "render(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V", at = @At(value = "TAIL"))
    private void renderEndTrident(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {
        // Model is air without that ?!
        if (stack.isOf(ItemsRegistry.END_TRIDENT)) {
            EndTridentItemRenderer.render(stack, matrices, vertexConsumers, light, overlay);
        }
    }
}
