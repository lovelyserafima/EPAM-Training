package com.epam.audiomanager.database.dao.impl.user;

import com.epam.audiomanager.entity.user.User;
import com.epam.audiomanager.exception.ProjectException;

public interface UserDAOImpl {
    User findUserByEmailAndPassword(String email, String password) throws ProjectException;
    User findUserByEmail(String email) throws ProjectException;
    User findUserByLogin(String login) throws ProjectException;
}
