package net.Non.villagekeeper.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class VillageUtils {

    public static void getVillageStats(PlayerEntity player) {
        ScoreboardObjective objective = player.getScoreboard().getObjective("VillagerCount");
        ServerCommandSource source = player.getCommandSource();
        source.sendFeedback(Text.literal("isKeepingVillage = " + VillageStateSaver.getServerState(player.getServer()).isKeepingVillage), false);
        source.sendFeedback(Text.literal("ticks village survived = " + VillageStateSaver.getServerState(player.getServer()).ticksVillageSurvived), false);
        source.sendFeedback(Text.literal("objective = " + objective), false);
    }


}
