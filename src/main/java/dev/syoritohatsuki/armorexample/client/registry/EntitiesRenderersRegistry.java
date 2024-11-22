package dev.syoritohatsuki.armorexample.client.registry;

import dev.syoritohatsuki.armorexample.client.render.entity.EndTridentEntityRenderer;
import dev.syoritohatsuki.armorexample.registry.EntitiesRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public final class EntitiesRenderersRegistry {
    public EntitiesRenderersRegistry() {
        EntityRendererRegistry.register(EntitiesRegistry.END_TRIDENT_ENTITY, EndTridentEntityRenderer::new);
    }
}
