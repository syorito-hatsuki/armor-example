package dev.syoritohatsuki.tridentexample;

import com.mojang.logging.LogUtils;
import dev.syoritohatsuki.tridentexample.registry.ItemsRegistry;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class TridentExampleMod implements ModInitializer {

    public static final String MOD_ID = "trident-example";
    public static final Logger serverLogger = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        serverLogger.info("{} initialized with mod-id {}", getClass().getSimpleName(), MOD_ID);

        ItemsRegistry.init();
    }
}