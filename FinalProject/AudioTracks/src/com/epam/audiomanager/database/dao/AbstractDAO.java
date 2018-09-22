package com.epam.audiomanager.database.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.epam.audiomanager.entity.Entity;
import com.epam.audiomanager.exception.ProjectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractDAO <K, T extends Entity> {
    protected Connection connection;
    protected static final Logger LOGGER = LogManager.getLogger(AbstractDAO.class);

    public abstract void findAll() throws ProjectException;

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    public void close(Statement statement){
        try{
            if (statement != null){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

