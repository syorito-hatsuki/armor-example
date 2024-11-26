package dev.syoritohatsuki.tridentexample.client.registry;

import dev.syoritohatsuki.tridentexample.client.render.entity.NetherTridentEntityRenderer;
import dev.syoritohatsuki.tridentexample.registry.EntitiesRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public final class EntitiesRenderersRegistry {
    public static void init() {
        EntityRendererRegistry.register(EntitiesRegistry.NETHER_TRIDENT_ENTITY, NetherTridentEntityRenderer::new);
    }
}
