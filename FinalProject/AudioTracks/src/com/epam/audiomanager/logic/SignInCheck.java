package com.epam.audiomanager.logic;

import com.epam.audiomanager.database.dao.TransactionManager;
import com.epam.audiomanager.database.dao.impl.user.UserDAO;
import com.epam.audiomanager.entity.user.User;
import com.epam.audiomanager.exception.ProjectException;
import com.epam.audiomanager.util.ConstantValues;
import com.epam.audiomanager.util.Encryption;
import com.epam.audiomanager.util.valid.ValidationEmail;
import com.epam.audiomanager.util.valid.ValidationPassword;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

public class SignInCheck {
    private static final Logger LOGGER = LogManager.getLogger(SignInCheck.class);

    public static User checkLogin(HttpServletRequest httpServletRequest) throws ProjectException {
        String email = httpServletRequest.getParameter(ConstantValues.EMAIL);
        String password = httpServletRequest.getParameter(ConstantValues.PASSWORD);

        User user = null;

        if (ValidationEmail.checkEmail(email) && ValidationPassword.checkPassword(password)) {
            password = Encryption.encryptPassword(password);
            TransactionManager transactionManager = new TransactionManager();
            UserDAO userDAO = new UserDAO();

            try {
                transactionManager.startTransaction(userDAO);
                user = userDAO.findUserByEmailAndPassword(email, password);
            } catch (ProjectException e) {
                LOGGER.error("SQLException", e);
                throw new ProjectException("SQLException", e);
            }

            transactionManager.endTransaction();
        }

        return user;
    }
}
