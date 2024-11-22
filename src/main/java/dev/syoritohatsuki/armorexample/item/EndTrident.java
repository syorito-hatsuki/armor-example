package dev.syoritohatsuki.armorexample.item;

import dev.syoritohatsuki.armorexample.entity.EndTridentEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class EndTrident extends TridentItem {
    public EndTrident(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        var endTridentEntity = new EndTridentEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1));
        endTridentEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return endTridentEntity;
    }
}
