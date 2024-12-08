package dev.syoritohatsuki.hand2dworld3d.client.render.item;

import dev.syoritohatsuki.hand2dworld3d.Hand2DWorld3DMod;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;

public final class ModItemRenderer {
    public static final ModelIdentifier RADIATION_STAFF_2D = ModelIdentifier.ofInventoryVariant(Identifier.of(Hand2DWorld3DMod.MOD_ID, "radiation_staff"));
    public static final ModelIdentifier RADIATION_STAFF_3D = ModelIdentifier.ofInventoryVariant(Identifier.of(Hand2DWorld3DMod.MOD_ID, "radiation_staff_3d"));
}
