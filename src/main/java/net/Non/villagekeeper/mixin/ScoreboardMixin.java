package net.Non.villagekeeper.mixin;

import net.Non.villagekeeper.util.VillageStateSaver;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Scoreboard.class)
public class ScoreboardMixin {
    private static MinecraftServer server;

    static {
        ServerLifecycleEvents.SERVER_STARTED.register(minecraftServer -> {
            server = minecraftServer;
        });
    }

    @Inject(method = "addObjective", at = @At("RETURN"))
    public void checkObjectiveName(String name, ScoreboardCriterion criterion, Text displayName, ScoreboardCriterion.RenderType renderType, CallbackInfoReturnable<ScoreboardObjective> cir) {
        if (name.equals("CurrentVillagerCount")) {
            VillageStateSaver.getServerState(server).setKeepingVillage(true);
        }
    }

    @Inject(method = "removeObjective", at = @At("RETURN"))
    public void checkObjectiveName(ScoreboardObjective objective, CallbackInfo ci) {
        if (objective.getName().equals("CurrentVillagerCount")) {
            VillageStateSaver.getServerState(server).setKeepingVillage(false);
        }
    }





}
