package com.epam.audiomanager.util.property;

import java.util.Locale;
import java.util.ResourceBundle;

public enum MessageManager {
    EN(ResourceBundle.getBundle("resources/message", new Locale("en", "US"))),
    RU(ResourceBundle.getBundle("resources/message", new Locale("ru", "RU")));

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
