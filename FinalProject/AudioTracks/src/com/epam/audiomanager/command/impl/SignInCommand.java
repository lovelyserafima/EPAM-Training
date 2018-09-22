package com.epam.audiomanager.command.impl;

import com.epam.audiomanager.command.Command;
import com.epam.audiomanager.controller.router.Router;
import com.epam.audiomanager.entity.user.Client;
import com.epam.audiomanager.entity.user.User;
import com.epam.audiomanager.exception.ProjectException;
import com.epam.audiomanager.logic.SignInCheck;
import com.epam.audiomanager.util.ConstantValues;
import com.epam.audiomanager.util.property.ConfigurationManager;
import com.epam.audiomanager.util.property.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;


public class SignInCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SignInCommand.class);

    @Override
    public Router execute(HttpServletRequest httpServletRequest) {
        MessageManager messageManager = MessageManager.defineLocale
                        ((String) httpServletRequest.getSession().getAttribute(ConstantValues.CHANGE_LANGUAGE));
        httpServletRequest.getSession().setAttribute(ConstantValues.ERROR_SIGN_IN_MESSAGE, null);
        String page;
        try {
            User user = SignInCheck.checkLogin(httpServletRequest);
            if (user != null) {
                page = user.getClass() == Client.class ?
                        ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_CLIENT) :
                        ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_ADMIN);
            } else {
                page = ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_LOGIN);
                httpServletRequest.setAttribute(ConstantValues.ERROR_SIGN_IN_MESSAGE,
                        messageManager.getMessage(ConstantValues.PATH_ERROR_SIGN_IN_MESSAGE));
            }
        } catch (ProjectException e) {
            page = ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_ERROR);
        }
        Router router = new Router();
        router.setPagePath(page);
        return router;
    }
}
