package dev.syoritohatsuki.armorexample.client;

import com.mojang.logging.LogUtils;
import dev.syoritohatsuki.armorexample.client.registry.EntitiesRenderersRegistry;
import dev.syoritohatsuki.armorexample.client.render.item.EndTridentItemRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

import static dev.syoritohatsuki.armorexample.ArmorExampleMod.MOD_ID;
import static dev.syoritohatsuki.armorexample.registry.ItemsRegistry.END_TRIDENT;

public class ArmorExampleModClient implements ClientModInitializer {

    public static final Logger clientLogger = LogUtils.getLogger();
    public static final ModelIdentifier TRIDENT_ID = ModelIdentifier.ofInventoryVariant(Identifier.of(MOD_ID, "end_trident"));
    @Override
    public void onInitializeClient() {
        clientLogger.info("{} initialized with mod-id {}", getClass().getSimpleName(), MOD_ID);
        BuiltinItemRendererRegistry.INSTANCE.register(END_TRIDENT, new EndTridentItemRenderer());
        new EntitiesRenderersRegistry();
    }
}
