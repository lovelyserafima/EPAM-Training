/*
package com.epam.audiomanager.logic;

import com.epam.audiomanager.exception.ProjectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService {
    private static final String EN_US = "en_US";
    private static final String RU_RU = "ru_RU";
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    public String changeLanguage(String locale) throws ProjectException {
        if (locale == null){
            return EN_US;
        }
        switch (locale){
            case EN_US:
                return EN_US;
            case RU_RU:
                return RU_RU;
            default:
                LOGGER.error("changeLanguageException");
                throw new ProjectException("changeLanguageException");
        }
    }
}
*/
