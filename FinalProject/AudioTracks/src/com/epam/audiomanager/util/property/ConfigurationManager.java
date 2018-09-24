package com.epam.audiomanager.util.property;

import com.epam.audiomanager.util.ConstantValues;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(ConstantValues.CONFIG);

    private ConfigurationManager(){}

    public static String getProperty(String key){
        return RESOURCE_BUNDLE.getString(key);
    }
}
