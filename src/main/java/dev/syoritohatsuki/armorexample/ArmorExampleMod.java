package dev.syoritohatsuki.armorexample;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class ArmorExampleMod implements ModInitializer {

    public static final String MOD_ID = "armor-example";
    Logger logger = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        logger.info("{} initialized with mod-id {}", getClass().getSimpleName(),  MOD_ID);
    }
}