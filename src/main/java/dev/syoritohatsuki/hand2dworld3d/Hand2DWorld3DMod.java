package dev.syoritohatsuki.hand2dworld3d;

import com.mojang.logging.LogUtils;
import dev.syoritohatsuki.hand2dworld3d.registry.ItemsRegistry;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class Hand2DWorld3DMod implements ModInitializer {

    public static final String MOD_ID = "hand-2d-world-3d";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("{} initialized with mod-id {}", getClass().getSimpleName(), MOD_ID);

        ItemsRegistry.init();
    }
}