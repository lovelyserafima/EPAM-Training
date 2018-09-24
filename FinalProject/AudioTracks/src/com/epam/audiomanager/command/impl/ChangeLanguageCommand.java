package com.epam.audiomanager.command.impl;

import com.epam.audiomanager.command.Command;
import com.epam.audiomanager.controller.router.Router;
import com.epam.audiomanager.util.ConstantValues;
import com.epam.audiomanager.util.property.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class ChangeLanguageCommand implements Command {
    private String locale;

    ChangeLanguageCommand(String locale){
        this.locale = locale;
    }

    @Override
    public Router execute(HttpServletRequest httpServletRequest) {
        httpServletRequest.setAttribute(ConstantValues.CHANGE_LANGUAGE, locale);
        httpServletRequest.getSession().setAttribute(ConstantValues.CHANGE_LANGUAGE, locale);
        Router router = new Router();
        router.setPagePath(ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_LOGIN));
        return router;
    }
}
