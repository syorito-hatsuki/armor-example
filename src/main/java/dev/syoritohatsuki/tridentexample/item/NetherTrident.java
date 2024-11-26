package dev.syoritohatsuki.tridentexample.item;

import dev.syoritohatsuki.tridentexample.entity.NetherTridentEntity;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class NetherTrident extends TridentItem {
    public NetherTrident(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        var netherTridentEntity = new NetherTridentEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1));
        netherTridentEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return netherTridentEntity;
    }

    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int chargeTime = this.getMaxUseTime(stack, user) - remainingUseTicks;
            if (chargeTime >= 10) {
                float riptideStrength = EnchantmentHelper.getTridentSpinAttackStrength(stack, playerEntity);

                if (riptideStrength > 0.0F && !playerEntity.isTouchingWaterOrRain() || stack.willBreakNextUse())
                    return false;

                RegistryEntry<SoundEvent> registryEntry = EnchantmentHelper.getEffect(stack, EnchantmentEffectComponentTypes.TRIDENT_SOUND).orElse(SoundEvents.ITEM_TRIDENT_THROW);

                if (world instanceof ServerWorld serverWorld) {
                    stack.damage(1, playerEntity);
                    if (riptideStrength == 0.0F) {
                        NetherTridentEntity netherTridentEntity = ProjectileEntity.spawnWithVelocity(NetherTridentEntity::new, serverWorld, stack, playerEntity, 0.0F, 2.5F, 1.0F);
                        if (playerEntity.isInCreativeMode()) {
                            netherTridentEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                        } else {
                            playerEntity.getInventory().removeOne(stack);
                        }

                        world.playSoundFromEntity(null, netherTridentEntity, registryEntry.value(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                        return true;
                    }
                }

                playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));

                if (!(riptideStrength > 0.0F)) return false;

                float yaw = playerEntity.getYaw();
                float pitch = playerEntity.getPitch();
                float xVelocity = -MathHelper.sin(yaw * (float) Math.PI / 180.0F) * MathHelper.cos(pitch * (float) Math.PI / 180.0F);
                float yVelocity = -MathHelper.sin(pitch * (float) Math.PI / 180.0F);
                float zVelocity = MathHelper.cos(yaw * (float) Math.PI / 180.0F) * MathHelper.cos(pitch * (float) Math.PI / 180.0F);
                float velocityMagnitude = MathHelper.sqrt(xVelocity * xVelocity + yVelocity * yVelocity + zVelocity * zVelocity);

                xVelocity *= riptideStrength / velocityMagnitude;
                yVelocity *= riptideStrength / velocityMagnitude;
                zVelocity *= riptideStrength / velocityMagnitude;

                playerEntity.addVelocity(xVelocity, yVelocity, zVelocity);
                playerEntity.useRiptide(20, 8.0F, stack);

                if (playerEntity.isOnGround()) {
                    playerEntity.move(MovementType.SELF, new Vec3d(0.0, 1.1999999F, 0.0));
                }

                world.playSoundFromEntity(null, playerEntity, registryEntry.value(), SoundCategory.PLAYERS, 1.0F, 1.0F);

                return true;
            }
        }
        return false;
    }
}