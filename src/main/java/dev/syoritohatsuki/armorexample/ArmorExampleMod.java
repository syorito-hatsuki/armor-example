package dev.syoritohatsuki.armorexample;

import com.mojang.logging.LogUtils;
import dev.syoritohatsuki.armorexample.registry.ItemsRegistry;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class ArmorExampleMod implements ModInitializer {

    public static final String MOD_ID = "armor-example";
    public static final Logger serverLogger = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        serverLogger.info("{} initialized with mod-id {}", getClass().getSimpleName(), MOD_ID);

        new ItemsRegistry();
    }
}