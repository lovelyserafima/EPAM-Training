package com.epam.audiomanager.logic;

import com.epam.audiomanager.database.dao.DAOManager;
import com.epam.audiomanager.database.dao.impl.user.UserDAOImpl;
import com.epam.audiomanager.entity.user.User;
import com.epam.audiomanager.exception.ProjectException;
import com.epam.audiomanager.util.Encryption;
import com.epam.audiomanager.util.valid.ValidationEmail;
import com.epam.audiomanager.util.valid.ValidationPassword;

public class SignInLogic {
    public static User checkLogin(String email, String password) throws ProjectException {
        User user = null;

        if (ValidationEmail.isCorrectEmail(email) && ValidationPassword.isCorrectPassword(password)) {
            DAOManager daoManager = new DAOManager();
            UserDAOImpl userDAO = new UserDAOImpl();
            password = Encryption.encryptPassword(password);

            try {
                daoManager.startDAO(userDAO);
                user = userDAO.findUserByEmailAndPassword(email, password);
            } finally {
                daoManager.endDAO();
            }
        }

        return user;
    }
}
