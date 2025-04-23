package net.Non.villagekeeper.util;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.World;

public class VillageStateSaver extends PersistentState {

    public boolean isKeepingVillage = false;
    public long ticksVillageSurvived = 0;


    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putBoolean("isKeepingVillage", isKeepingVillage);
        nbt.putLong("ticksVillageSurvived", ticksVillageSurvived);
        return nbt;
    }

    public static VillageStateSaver createFromNbt(NbtCompound nbt) {
        VillageStateSaver state = new VillageStateSaver();
        state.isKeepingVillage = nbt.getBoolean("isKeepingVillage");
        state.ticksVillageSurvived = nbt.getLong("ticksVillageSurvived");
        return state;
    }

    public void setKeepingVillage(boolean value) {
        this.isKeepingVillage = value;
        this.markDirty();
    }

    public void updateTicksVillageSurvived() {
        this.ticksVillageSurvived += 1200;
        this.markDirty();
    }

    public static VillageStateSaver getServerState(MinecraftServer server) {
        return server.getWorld(World.OVERWORLD)
                .getPersistentStateManager()
                .getOrCreate(VillageStateSaver::createFromNbt, VillageStateSaver::new, "village_state");
    }


}
