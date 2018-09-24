package com.epam.audiomanager.util.property;

import com.epam.audiomanager.util.ConstantValues;

import java.util.Locale;
import java.util.ResourceBundle;

public enum MessageManager {
    EN(ResourceBundle.getBundle(ConstantValues.MESSAGE, new Locale(ConstantValues.ENGLISH_LOCALE))),
    RU(ResourceBundle.getBundle(ConstantValues.MESSAGE, new Locale(ConstantValues.RUSSIAN_LOCALE)));

    private ResourceBundle resourceBundle;


    MessageManager(ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
    }

    public String getMessage(String key){
        return resourceBundle.getString(key);
    }

    public static MessageManager defineLocale(String locale){
        MessageManager messageManager = null;
        if (locale == null){
            messageManager = messageManager.RU;
        }
        messageManager = ("en_US".equals(locale)) ? messageManager.EN : messageManager.RU;
        return messageManager;
    }

}
