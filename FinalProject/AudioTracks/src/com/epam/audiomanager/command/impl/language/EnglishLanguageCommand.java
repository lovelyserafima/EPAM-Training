package com.epam.audiomanager.command.impl.language;

import com.epam.audiomanager.command.Command;
import com.epam.audiomanager.controller.router.Router;
import com.epam.audiomanager.util.ConstantValues;
import com.epam.audiomanager.util.property.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;

public class EnglishLanguageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest httpServletRequest) {
        httpServletRequest.setAttribute(ConstantValues.CHANGE_LANGUAGE, ConstantValues.ENGLISH_LOCALE);
        httpServletRequest.getSession().setAttribute(ConstantValues.CHANGE_LANGUAGE, ConstantValues.ENGLISH_LOCALE);
        Router router = new Router();
        router.setPagePath(ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_LOGIN));
        return router;
    }
}
