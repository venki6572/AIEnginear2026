package com.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigManager {
    private static final String CONFIG_FILE = "config.properties";
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new IllegalStateException("Configuration file not found: " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new ExceptionInInitializerError("Failed to load configuration: " + ex.getMessage());
        }
    }

    private ConfigManager() {
    }

    public static String getBaseUrl() {
        return System.getProperty("api.base.url", properties.getProperty("api.base.url")).trim();
    }

    public static String getUsername() {
        return System.getProperty("api.auth.username", properties.getProperty("api.auth.username")).trim();
    }

    public static String getPassword() {
        return System.getProperty("api.auth.password", properties.getProperty("api.auth.password")).trim();
    }

    public static String getEnvironment() {
        return System.getProperty("api.environment", properties.getProperty("api.environment", "qa")).trim();
    }
}
