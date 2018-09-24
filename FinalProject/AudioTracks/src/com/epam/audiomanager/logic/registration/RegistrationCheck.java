package com.epam.audiomanager.logic.registration;

import com.epam.audiomanager.entity.user.Client;
import com.epam.audiomanager.entity.user.TypeUser;
import com.epam.audiomanager.exception.ProjectException;
import com.epam.audiomanager.util.ConstantValues;
import com.epam.audiomanager.util.property.MessageManager;
import com.epam.audiomanager.util.valid.ValidationEmail;
import com.epam.audiomanager.util.valid.ValidationPassword;
import com.epam.audiomanager.util.valid.ValidationSamePasswords;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCheck {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationCheck.class);

    public static Client checkNewClient(HttpServletRequest httpServletRequest) throws ProjectException {
        String email = httpServletRequest.getParameter(ConstantValues.EMAIL);
        String password = httpServletRequest.getParameter(ConstantValues.PASSWORD);
        String samePassword = httpServletRequest.getParameter(ConstantValues.SAME_PASSWORD);
        String login = httpServletRequest.getParameter(ConstantValues.LOGIN);
        String firstName = httpServletRequest.getParameter(ConstantValues.FIRST_NAME);
        String secondName = httpServletRequest.getParameter(ConstantValues.SECOND_NAME);

        Client client;
        MessageManager messageManager = MessageManager.defineLocale
                ((String) httpServletRequest.getSession().getAttribute(ConstantValues.CHANGE_LANGUAGE));
        if (ValidationEmail.checkEmail(email)){
            if (ValidationPassword.checkPassword(password)){
                if (ValidationSamePasswords.checkSamePasswords(password, samePassword)){
                    try {
                        if (EmailCheck.checkEmail(email) == null){
                            if (LoginCheck.checkLogin(login) == null){
                                client = new Client(email, login, firstName, secondName, TypeUser.CLIENT);
                            } else {
                                httpServletRequest.getSession().setAttribute(ConstantValues.ERROR_WRONG_LOGIN,
                                        messageManager.getMessage(ConstantValues.PATH_ERROR_EXISTING_LOGIN));
                                client = null;
                            }
                        } else {
                            httpServletRequest.getSession().setAttribute(ConstantValues.ERROR_WRONG_EMAIL,
                                    messageManager.getMessage(ConstantValues.PATH_ERROR_EXISTING_EMAIL));
                            client = null;
                        }
                    } catch (ProjectException e) {
                        LOGGER.error("Error with searching user by email or login", e);
                        throw new ProjectException("Error with searching user by email or login", e);
                    }
                } else {
                    httpServletRequest.getSession().setAttribute(ConstantValues.ERROR_NOT_SAME_PASSWORDS,
                            messageManager.getMessage(ConstantValues.PATH_ERROR_NOT_THE_SAME_PASSWORDS));
                    client = null;
                }
            } else {
                httpServletRequest.getSession().setAttribute(ConstantValues.ERROR_WRONG_PASSWORD,
                        messageManager.getMessage(ConstantValues.PATH_ERROR_WRONG_PASSWORD));
                client = null;
            }
        } else {
            httpServletRequest.getSession().setAttribute(ConstantValues.ERROR_WRONG_EMAIL,
                    messageManager.getMessage(ConstantValues.PATH_ERROR_WRONG_EMAIL));
            client = null;
        }
        return client;
    }
}
