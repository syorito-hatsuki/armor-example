package dev.syoritohatsuki.tridentexample.registry;

import dev.syoritohatsuki.tridentexample.TridentExampleMod;
import dev.syoritohatsuki.tridentexample.entity.NetherTridentEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class EntitiesRegistry {
    public static final EntityType<NetherTridentEntity> NETHER_TRIDENT_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(TridentExampleMod.MOD_ID, "nether_trident"),
            EntityType.Builder.<NetherTridentEntity>create(NetherTridentEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
                    .makeFireImmune()
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TridentExampleMod.MOD_ID, "nether_trident")))
    );
}
