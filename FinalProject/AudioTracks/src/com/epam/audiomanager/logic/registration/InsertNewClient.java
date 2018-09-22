package com.epam.audiomanager.logic.registration;

import com.epam.audiomanager.database.dao.TransactionManager;
import com.epam.audiomanager.database.dao.impl.user.UserDAO;
import com.epam.audiomanager.entity.user.User;
import com.epam.audiomanager.exception.ProjectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertNewClient {
    private static final Logger LOGGER = LogManager.getLogger(InsertNewClient.class);
    public static void registerNewClient(User user, String encryptedPassword) throws ProjectException {
        TransactionManager transactionManager = new TransactionManager();
        UserDAO userDAO = new UserDAO();

        try {
            transactionManager.startTransaction(userDAO);
            userDAO.insert(user, encryptedPassword);
            transactionManager.commit();
            transactionManager.endTransaction();
        } catch (ProjectException e) {
            LOGGER.error("Error with registration new client", e);
            transactionManager.rollback();
            throw new ProjectException("Error with registration new client", e);
        }

    }
}
