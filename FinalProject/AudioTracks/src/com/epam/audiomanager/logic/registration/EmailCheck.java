package com.epam.audiomanager.logic.registration;

import com.epam.audiomanager.database.dao.TransactionManager;
import com.epam.audiomanager.database.dao.impl.user.UserDAO;
import com.epam.audiomanager.entity.user.User;
import com.epam.audiomanager.exception.ProjectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class EmailCheck {
    private static final Logger LOGGER = LogManager.getLogger(EmailCheck.class);

    static User checkEmail(String email) throws ProjectException {
        TransactionManager transactionManager = new TransactionManager();
        UserDAO userDAO = new UserDAO();
        transactionManager.startTransaction(userDAO);
        User user;
        try {
            user = userDAO.findUserByEmail(email);
        } catch (ProjectException e) {
            LOGGER.error("Error with searching user by email", e);
            throw new ProjectException("Error with searching user by email", e);
        }
        transactionManager.endTransaction();
        return user;
    }
}
