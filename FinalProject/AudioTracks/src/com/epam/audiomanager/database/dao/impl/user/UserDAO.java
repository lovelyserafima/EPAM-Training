package com.epam.audiomanager.database.dao.impl.user;

import com.epam.audiomanager.entity.user.User;
import com.epam.audiomanager.exception.ProjectException;

public interface UserDAO {
    User findUserByEmailAndPassword(String email, String password) throws ProjectException;
    boolean findUserByEmail(String email) throws ProjectException;
    boolean findUserByLogin(String login) throws ProjectException;
    boolean updateUserPassword(String login, String newPassword) throws ProjectException;
}
