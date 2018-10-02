package com.epam.audiomanager.logic;

import com.epam.audiomanager.database.dao.DAOManager;
import com.epam.audiomanager.database.dao.impl.user.UserDAOImpl;
import com.epam.audiomanager.exception.ProjectException;

public class ChangePasswordLogic {
    public static boolean changePassword(String login, String newPassword) throws ProjectException {
        DAOManager daoManager = new DAOManager();
        UserDAOImpl userDAO = new UserDAOImpl();
        boolean flag = false;
        try {
            daoManager.startDAO(userDAO);
            if (userDAO.updateUserPassword(login, newPassword)) {
                flag = true;
            }
            daoManager.commit();
        } catch (ProjectException e){
            daoManager.rollback();
            throw e;
        } finally{
            daoManager.endDAO();
        }
        return flag;
    }
}
