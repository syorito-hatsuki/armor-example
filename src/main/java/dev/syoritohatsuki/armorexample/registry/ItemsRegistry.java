package dev.syoritohatsuki.armorexample.registry;

import dev.syoritohatsuki.armorexample.ArmorExampleMod;
import dev.syoritohatsuki.armorexample.item.EndTrident;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public final class ItemsRegistry {

    public final static Item END_TRIDENT = register("end_trident", EndTrident::new, new Item.Settings()
            .maxDamage(250)
            .attributeModifiers(TridentItem.createAttributeModifiers())
            .component(DataComponentTypes.TOOL, TridentItem.createToolComponent())
            .enchantable(1)
            /*  When uncommented item is 3D only, when commented item is 2D only  */
            .modelId(Identifier.of(ArmorExampleMod.MOD_ID, "end_trident_in_hand")));

    private static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ArmorExampleMod.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }
}
