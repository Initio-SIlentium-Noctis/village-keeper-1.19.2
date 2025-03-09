package net.Non.villageguardian.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;
import java.util.Objects;

import static net.Non.villageguardian.util.config.ConfigFileUtils.getValueFromConfig;
import static net.Non.villageguardian.util.config.ConfigKeys.SKELETON_FOLLOW_RANGE_KEY;

@Mixin(AbstractSkeletonEntity.class)
public abstract class AbstractSkeletonEntityMixin extends HostileEntity {

    protected AbstractSkeletonEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "createAbstractSkeletonAttributes", at = @At("RETURN"), cancellable = true)
    private static void modifyAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) throws IOException {
        DefaultAttributeContainer.Builder builder = HostileEntity.createHostileAttributes();
        builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
        builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, Double.parseDouble(Objects.requireNonNull(getValueFromConfig(SKELETON_FOLLOW_RANGE_KEY))));
        cir.setReturnValue(builder);
    }



}
