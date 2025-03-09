package net.Non.villageguardian.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.io.IOException;
import java.util.Objects;

import static net.Non.villageguardian.util.config.ConfigFileUtils.getValueFromConfig;
import static net.Non.villageguardian.util.config.ConfigKeys.ZOMBIE_FOLLOW_RANGE_KEY;

@Mixin(ZombieEntity.class)
public abstract class ZombieEntityMixin extends HostileEntity {

    protected ZombieEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }


    @ModifyConstant(method = "createZombieAttributes", constant = @Constant(doubleValue = 35.0, ordinal = 0))
    private static double modifyZombieFollowRange(double original) throws IOException {
        return Double.parseDouble(Objects.requireNonNull(getValueFromConfig(ZOMBIE_FOLLOW_RANGE_KEY)));
    }





}
