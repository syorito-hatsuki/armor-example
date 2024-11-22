package dev.syoritohatsuki.armorexample.mixin.client;

import dev.syoritohatsuki.armorexample.registry.ItemsRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static dev.syoritohatsuki.armorexample.client.ArmorExampleModClient.TRIDENT_ID;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @Shadow @Final private BakedModelManager bakedModelManager;

    @ModifyVariable(method="renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;Z)V", at= @At(value = "HEAD"),argsOnly = true)
    private BakedModel isEndTridentForRender(
            BakedModel original,
    		ItemStack stack,
            ModelTransformationMode transformationMode,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            int overlay,
            BakedModel model,
            boolean useInventoryModel
    ) {
        if (stack.isOf(ItemsRegistry.END_TRIDENT) && useInventoryModel) return this.bakedModelManager.getModel(TRIDENT_ID);
        return original;
    }
}
