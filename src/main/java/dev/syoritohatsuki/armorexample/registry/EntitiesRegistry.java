package dev.syoritohatsuki.armorexample.registry;

import dev.syoritohatsuki.armorexample.ArmorExampleMod;
import dev.syoritohatsuki.armorexample.entity.EndTridentEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class EntitiesRegistry {
    public static final EntityType<EndTridentEntity> END_TRIDENT_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(ArmorExampleMod.MOD_ID, "end_trident"),
            EntityType.Builder.<EndTridentEntity>create(SpawnGroup.MISC)
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(ArmorExampleMod.MOD_ID, "end_trident")))
    );
}
