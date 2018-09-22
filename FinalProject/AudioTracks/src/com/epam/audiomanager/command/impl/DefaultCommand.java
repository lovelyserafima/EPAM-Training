package com.epam.audiomanager.command.impl;

import com.epam.audiomanager.command.Command;
import com.epam.audiomanager.controller.router.Router;
import com.epam.audiomanager.util.ConstantValues;
import com.epam.audiomanager.util.property.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public Router execute(HttpServletRequest httpServletRequest) {
        Router router = new Router();
        String pagePath = ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_LOGIN);
        router.setPagePath(pagePath);
        return router;
    }
}
