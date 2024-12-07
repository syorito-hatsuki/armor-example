package dev.syoritohatsuki.hand2dworld3d.registry;

import dev.syoritohatsuki.hand2dworld3d.Hand2DWorld3DMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ItemsRegistry {

    public static final Item RADIATION_STUFF = register(
            new Item(new Item.Settings()),
            "radiation_stuff"
    );

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) ->
                itemGroup.addAfter(Items.TRIDENT, RADIATION_STUFF)
        );
    }

    public static Item register(Item item, String id) {
        return Registry.register(Registries.ITEM, Identifier.of(Hand2DWorld3DMod.MOD_ID, id), item);
    }
}
