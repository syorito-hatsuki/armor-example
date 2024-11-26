package dev.syoritohatsuki.tridentexample.registry;

import dev.syoritohatsuki.tridentexample.client.render.item.NetherTridentItemRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;

public final class BuildInItemsRendererRegistry {
    public static void init() {
        BuiltinItemRendererRegistry.INSTANCE.register(ItemsRegistry.NETHER_TRIDENT, new NetherTridentItemRenderer());
    }
}
