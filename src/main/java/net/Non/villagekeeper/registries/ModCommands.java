package net.Non.villagekeeper.registries;

import net.Non.villagekeeper.commands.GetVillageStatsCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModCommands {

    public static void register() {
        CommandRegistrationCallback.EVENT.register(GetVillageStatsCommand::register);
    }


}
