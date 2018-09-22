package com.epam.audiomanager.database.dao;

import com.epam.audiomanager.database.pool.ConnectionPool;
import com.epam.audiomanager.exception.ProjectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private static final Logger LOGGER = LogManager.getLogger(TransactionManager.class);
    private Connection connection;
    private List<AbstractDAO> abstractDAOS;

    public TransactionManager(){
        abstractDAOS = new ArrayList<>();
    }

    public void startTransaction(AbstractDAO abstractDAO, AbstractDAO... abstractDAOS) throws ProjectException {
        if (connection == null){
            connection = ConnectionPool.getInstance().getConnection();
        }
        try{
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
            throw new ProjectException("SQLException", e);
        }
        abstractDAO.setConnection(connection);
        this.abstractDAOS.add(abstractDAO);
        for (AbstractDAO currentDao: abstractDAOS){
            currentDao.setConnection(connection);
            this.abstractDAOS.add(currentDao);
        }
    }

    public void endTransaction(){
        for (AbstractDAO currentDao: abstractDAOS){
            currentDao.setConnection(null);
        }
        abstractDAOS.clear();
        if (connection != null){
            ConnectionPool.getInstance().releaseConnection(connection);
            connection = null;
        }
    }

    public void commit() throws ProjectException {
        if (connection != null){
            try{
                connection.commit();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
                throw new ProjectException("SQLException", e);
            }
        }
    }

    public void rollback() throws ProjectException {
        if (connection != null){
            try{
                connection.rollback();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
                throw new ProjectException("SQLException", e);
            }
        }
    }
}
