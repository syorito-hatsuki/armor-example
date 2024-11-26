package dev.syoritohatsuki.tridentexample.client;

import com.mojang.logging.LogUtils;
import dev.syoritohatsuki.tridentexample.TridentExampleMod;
import dev.syoritohatsuki.tridentexample.client.registry.EntitiesRenderersRegistry;
import dev.syoritohatsuki.tridentexample.registry.BuildInItemsRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;

public class TridentExampleModClient implements ClientModInitializer {

    public static final Logger clientLogger = LogUtils.getLogger();

    @Override
    public void onInitializeClient() {
        clientLogger.info("{} initialized with mod-id {}", getClass().getSimpleName(), TridentExampleMod.MOD_ID);

        BuildInItemsRendererRegistry.init();
        EntitiesRenderersRegistry.init();
    }
}
