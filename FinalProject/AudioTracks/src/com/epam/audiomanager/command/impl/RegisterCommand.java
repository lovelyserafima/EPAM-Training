package com.epam.audiomanager.command.impl;

import com.epam.audiomanager.command.Command;
import com.epam.audiomanager.controller.router.RouteType;
import com.epam.audiomanager.controller.router.Router;
import com.epam.audiomanager.entity.user.Client;
import com.epam.audiomanager.exception.ProjectException;
import com.epam.audiomanager.logic.registration.RegistrationCheck;
import com.epam.audiomanager.logic.registration.mail.EmailConfirm;
import com.epam.audiomanager.util.ConfirmCodeGenerator;
import com.epam.audiomanager.util.ConstantValues;
import com.epam.audiomanager.util.property.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class RegisterCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(RegisterCommand.class);
    @Override
    public Router execute(HttpServletRequest httpServletRequest) throws ProjectException {
        Router router = new Router();
        Client client;
        String page;
        try {
            client = RegistrationCheck.checkNewClient(httpServletRequest);
            if (client == null){
                page = ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_REGISTRATION);
            } else {
                String confirmCode = ConfirmCodeGenerator.generateConfirmCode();
                ResourceBundle resourceBundle = ResourceBundle.getBundle(ConstantValues.MAIL);
                new EmailConfirm(client.getEmail(), ConstantValues.SUBJECT, confirmCode, resourceBundle).start();
                page = ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_CONFIRM);
                /*InsertNewClient.registerNewClient(client,
                        Encryption.encryptPassword(httpServletRequest.getParameter(ConstantValues.PASSWORD)));
                router.setPagePath(ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_MAINCLIENT));*/
            }
        } catch (ProjectException e) {
            LOGGER.error("Registration error", e);
            page = ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_ERROR);
        }
        router.setPagePath(page);
        router.setRouteType(RouteType.FORWARD);
        return router;
    }
}
