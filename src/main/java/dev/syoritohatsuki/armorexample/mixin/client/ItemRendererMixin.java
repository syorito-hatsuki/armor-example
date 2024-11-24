package dev.syoritohatsuki.armorexample.mixin.client;

import dev.syoritohatsuki.armorexample.registry.ItemsRegistry;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static dev.syoritohatsuki.armorexample.client.ArmorExampleModClient.TRIDENT_ID;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow @Final private BakedModelManager bakedModelManager;

    @Shadow private static boolean shouldUseInventoryModel(ModelTransformationMode transformationMode) { throw new AssertionError(); };

    @ModifyVariable(method={
            "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;Z)V",
            "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;Z)V"
    }, at= @At(value = "HEAD"),argsOnly = true)
    private BakedModel isEndTridentForRender(
            BakedModel original,
            ItemStack stack,
            ModelTransformationMode transformationMode
    ) {
        if (stack.isOf(ItemsRegistry.END_TRIDENT) && shouldUseInventoryModel(transformationMode)) return this.bakedModelManager.getModel(TRIDENT_ID);
        return original;
    }
}
