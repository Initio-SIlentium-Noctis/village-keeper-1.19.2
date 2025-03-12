package net.Non.villagekeeper;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.LivingEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

import static net.Non.villagekeeper.util.config.ConfigFileUtils.createIfNotExistsConfigFile;
import static net.minecraft.entity.EntityType.VILLAGER;

public class VillageKeeper implements ModInitializer, ClientModInitializer {
	public static final String MOD_ID = "village_keeper";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		createIfNotExistsConfigFile();
	}



	@Override
	public void onInitializeClient() {

	}





}
