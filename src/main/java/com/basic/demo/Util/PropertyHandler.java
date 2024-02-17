package com.basic.demo.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {
    private static Properties configProp;

    public PropertyHandler() {
    }

    public static Properties loadPropertyFile(String fileName) {
        configProp = new Properties();
        String propertyFilePath = null;

        try {
            propertyFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "propertyFiles" + File.separator + fileName + ".properties";
            configProp.load(new FileInputStream(new File(propertyFilePath)));
        } catch (IOException e) {
            System.out.println("Failed to load property file");
            throw new RuntimeException(e);
        }
        return configProp;
    }

    public static String getProperty(String key) {
        return configProp.getProperty(key);
    }
}