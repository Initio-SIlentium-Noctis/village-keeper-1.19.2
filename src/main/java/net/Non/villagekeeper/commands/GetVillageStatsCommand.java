package net.Non.villagekeeper.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import static net.Non.villagekeeper.util.VillageUtils.getVillageStats;

public class GetVillageStatsCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("getVillageStats")
                .executes(context -> run(context.getSource())));
    }

    private static int run (ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        if (player != null) {
            getVillageStats(player);
            return 1;
        } else
            return 0;
    }

}
