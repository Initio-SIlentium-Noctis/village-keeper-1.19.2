package net.Non.villagekeeper.util.config;

import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.Files;

import static net.Non.villagekeeper.VillageKeeper.MOD_ID;

public class ConfigFileUtils {

    private static final String CONFIG_FILE_PATH = "/assets/villagekeeper/default.cfg";
    private static final String CONFIG_FILE_NAME = "settings.cfg";


    /** Method creates (if not created yet) a config file */
    public static void createIfNotExistsConfigFile() {

        File configDir = new File(FabricLoader.getInstance().getConfigDirectory(), MOD_ID);

        if (!configDir.exists()) {
            configDir.mkdirs();
        }

        File configFile = new File(configDir, CONFIG_FILE_NAME);

        if (!configFile.exists()) {
            try {
                createDefaultConfig(configFile);
                System.out.println("Configuration file created with default values");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Configuration file already exists");
        }
    }

    /** Method copies all default settings and entries from template config file in resources directory */
    private static void createDefaultConfig(File configFile) throws IOException {
        try (InputStream inputStream = ConfigFileUtils.class.getResourceAsStream(CONFIG_FILE_PATH)) {
            if (inputStream == null) {
                throw new IOException("Default config file not found in resources !");
            }
            Files.copy(inputStream, configFile.toPath());
        }
    }

    /** Method gets value from config file by provided string attribute name (see ConfigKeys) */
    public static String getValueFromConfig(String attribute) throws IOException {
        File configDir = new File(FabricLoader.getInstance().getConfigDirectory(), MOD_ID);
        File configFile = new File(configDir, CONFIG_FILE_NAME);

        if (!configFile.exists()) {
            createIfNotExistsConfigFile();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(configFile.toPath())))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    if (key.equals(attribute)) {
                        return value;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }







}
