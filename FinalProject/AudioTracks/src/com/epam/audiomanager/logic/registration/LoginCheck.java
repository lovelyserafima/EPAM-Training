package com.epam.audiomanager.logic.registration;

import com.epam.audiomanager.database.dao.TransactionManager;
import com.epam.audiomanager.database.dao.impl.user.UserDAO;
import com.epam.audiomanager.entity.user.User;
import com.epam.audiomanager.exception.ProjectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginCheck {
    private static final Logger LOGGER = LogManager.getLogger(EmailCheck.class);

    public static User checkLogin(String login) throws ProjectException {
        TransactionManager transactionManager = new TransactionManager();
        UserDAO userDAO = new UserDAO();
        transactionManager.startTransaction(userDAO);
        User user;
        try {
            user = userDAO.findUserByLogin(login);
        } catch (ProjectException e) {
            LOGGER.error("Error with searching user by login", e);
            throw new ProjectException("Error with searching user by login", e);
        }
        transactionManager.endTransaction();
        return user;
    }
}
