package com.epam.audiomanager.command.impl;

import com.epam.audiomanager.command.Command;
import com.epam.audiomanager.controller.router.RouteType;
import com.epam.audiomanager.controller.router.Router;
import com.epam.audiomanager.util.ConstantValues;
import com.epam.audiomanager.util.property.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    @Override
    public Router execute(HttpServletRequest httpServletRequest) {
        Router router = new Router();
        String page = ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_REGISTRATION);
        router.setPagePath(page);
        router.setRouteType(RouteType.FORWARD);
        httpServletRequest.getSession().setAttribute(ConstantValues.ERROR_WRONG_PASSWORD, null);
        httpServletRequest.getSession().setAttribute(ConstantValues.ERROR_NOT_SAME_PASSWORDS, null);
        return router;
    }
}
