package net.Non.villagekeeper.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;
import java.util.Objects;

import static net.Non.villagekeeper.util.config.ConfigFileUtils.getValueFromConfig;
import static net.Non.villagekeeper.util.config.ConfigKeys.SPIDER_FOLLOW_RANGE_KEY;

@Mixin(SpiderEntity.class)
public abstract class SpiderEntityMixin extends HostileEntity {

    protected SpiderEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals", at = @At("TAIL"))
    public void initGoals(CallbackInfo ci) {
        this.targetSelector.add(3, new SpiderEntity.TargetGoal<MerchantEntity>((SpiderEntity)(Object)this, MerchantEntity.class));
    }

    @Inject(method = "createSpiderAttributes", at = @At("RETURN"), cancellable = true)
    private static void modifyAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) throws IOException {
        DefaultAttributeContainer.Builder builder = HostileEntity.createHostileAttributes();
        builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f).add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0);
        builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, Double.parseDouble(Objects.requireNonNull(getValueFromConfig(SPIDER_FOLLOW_RANGE_KEY))));
        cir.setReturnValue(builder);
    }




}
