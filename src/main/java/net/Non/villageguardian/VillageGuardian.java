package net.Non.villageguardian;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.Non.villageguardian.util.config.ConfigFileUtils.createIfNotExistsConfigFile;

public class VillageGuardian implements ModInitializer, ClientModInitializer {
	public static final String MOD_ID = "village_guardian";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		createIfNotExistsConfigFile();
	}



	@Override
	public void onInitializeClient() {

	}





}
