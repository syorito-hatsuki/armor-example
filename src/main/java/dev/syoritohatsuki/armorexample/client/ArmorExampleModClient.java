package dev.syoritohatsuki.armorexample.client;

import com.mojang.logging.LogUtils;
import dev.syoritohatsuki.armorexample.client.registry.EntitiesRenderersRegistry;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;

import static dev.syoritohatsuki.armorexample.ArmorExampleMod.MOD_ID;

public class ArmorExampleModClient implements ClientModInitializer {

    public static final Logger clientLogger = LogUtils.getLogger();

    @Override
    public void onInitializeClient() {
        clientLogger.info("{} initialized with mod-id {}", getClass().getSimpleName(), MOD_ID);

        new EntitiesRenderersRegistry();
    }
}
