package dev.syoritohatsuki.tridentexample.registry;

import dev.syoritohatsuki.tridentexample.TridentExampleMod;
import dev.syoritohatsuki.tridentexample.item.NetherTrident;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public final class ItemsRegistry {

    public final static Item NETHER_TRIDENT = register("nether_trident", NetherTrident::new, new Item.Settings()
            .maxDamage(250)
            .attributeModifiers(TridentItem.createAttributeModifiers())
            .component(DataComponentTypes.TOOL, TridentItem.createToolComponent())
            .enchantable(1)
            .fireproof()
            .modelId(Identifier.of(TridentExampleMod.MOD_ID, "nether_trident_in_hand")));

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Items.TRIDENT, NETHER_TRIDENT);
        });
    }

    private static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TridentExampleMod.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }
}
