package com.epam.audiomanager.command.impl;

import com.epam.audiomanager.command.Command;
import com.epam.audiomanager.controller.router.Router;
import com.epam.audiomanager.database.dao.TransactionManager;
import com.epam.audiomanager.database.dao.impl.user.UserDAO;
import com.epam.audiomanager.entity.user.Client;
import com.epam.audiomanager.entity.user.User;
import com.epam.audiomanager.exception.ProjectException;
import com.epam.audiomanager.logic.registration.InsertNewClient;
import com.epam.audiomanager.logic.registration.RegistrationCheck;
import com.epam.audiomanager.util.ConstantValues;
import com.epam.audiomanager.util.Encryption;
import com.epam.audiomanager.util.property.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(RegisterCommand.class);
    @Override
    public Router execute(HttpServletRequest httpServletRequest) throws ProjectException {
        Router router = new Router();
        Client client;
        try {
            client = RegistrationCheck.checkNewClient(httpServletRequest);
            if (client == null){
                router.setPagePath(ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_REGISTRATION));
            } else {
                InsertNewClient.registerNewClient(client,
                        Encryption.encryptPassword(httpServletRequest.getParameter(ConstantValues.PASSWORD)));
                router.setPagePath(ConfigurationManager.getProperty(ConstantValues.PATH_PAGE_MAINCLIENT));
            }
        } catch (ProjectException e) {
            LOGGER.error("Error with searching user by email", e);
            throw new ProjectException("Error with searching user by email", e);
        }

        return router;
    }
}
