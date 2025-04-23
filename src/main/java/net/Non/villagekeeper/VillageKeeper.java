package net.Non.villagekeeper;

import net.Non.villagekeeper.registries.ModCommands;
import net.Non.villagekeeper.registries.ModEvents;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.Non.villagekeeper.util.config.ConfigFileUtils.createIfNotExistsConfigFile;

public class VillageKeeper implements ModInitializer, ClientModInitializer {
	public static final String MOD_ID = "village_keeper";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		createIfNotExistsConfigFile();
		ModEvents.register();
		ModCommands.register();
	}



	@Override
	public void onInitializeClient() {

	}





}
