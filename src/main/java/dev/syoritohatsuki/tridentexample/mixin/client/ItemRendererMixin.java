package dev.syoritohatsuki.tridentexample.mixin.client;

import dev.syoritohatsuki.tridentexample.TridentExampleMod;
import dev.syoritohatsuki.tridentexample.registry.ItemsRegistry;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow
    @Final
    private BakedModelManager bakedModelManager;

    @Shadow
    private static boolean shouldUseInventoryModel(ModelTransformationMode transformationMode) {
        return true;
    }

    @Unique
    @Final
    private static final ModelIdentifier TRIDENT_MODEL_ID = ModelIdentifier.ofInventoryVariant(Identifier.of(TridentExampleMod.MOD_ID, "nether_trident"));


    @ModifyVariable(
            method = {
                    "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;Z)V",
                    "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;Z)V"
            },
            at = @At(value = "HEAD"),
            argsOnly = true
    )
    private BakedModel isNetherTridentForRender(BakedModel original, ItemStack stack, ModelTransformationMode transformationMode) {
        if (stack.isOf(ItemsRegistry.NETHER_TRIDENT) && shouldUseInventoryModel(transformationMode)) {
            return this.bakedModelManager.getModel(TRIDENT_MODEL_ID);
        }
        return original;
    }
}
