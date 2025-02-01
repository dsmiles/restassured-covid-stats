package com.github.dsmiles.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * This class reads properties from the config.properties file.
 * I've not implemented the singleton pattern here because the framework is relatively simple,
 * doesn't have strict resource constraints, and doesn't require global access to configuration
 * settings. It doesn't need the added complexity of a singleton.
 */
public class PropertiesReader {

    private static final String FILE_PATH = "properties//config.properties";

    private static String getProperty(String key) {
        Properties properties = new Properties();
        Path path = Paths.get("src", "test", "resources", "properties", "config.properties");
        String absolutePath = path.toFile().getAbsolutePath();

        try (FileInputStream fis = new FileInputStream(absolutePath)) {
            properties.load(fis);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getApiKey() {
        return getProperty("api.key");
    }

    public static String getBaseUri() {
        return getProperty("api.baseUri");
    }

    public static String getBasePath() {
        return getProperty("api.basePath");
    }
}
