package net.Non.villagekeeper.events;

import net.Non.villagekeeper.util.VillageStateSaver;
import net.minecraft.world.World;

public class ServerTickEvents {

    public static void register() {
        net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents.END_SERVER_TICK.register(server -> {

            if (server.getWorld(World.OVERWORLD).getTime() % 1200 == 0 && VillageStateSaver.getServerState(server).isKeepingVillage ) {
                VillageStateSaver.getServerState(server).updateTicksVillageSurvived();
            }
        });
    }

}
