/*
package com.epam.audiomanager.database.dao.impl;

import com.epam.audiomanager.database.dao.AbstractDAO;
import com.epam.audiomanager.entity.Entity;
import com.epam.audiomanager.database.pool.ConnectionPool;
import com.epam.audiomanager.database.pool.ProxyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenreDAO extends AbstractDAO {
    private static final String SHOW_ALL_INFORMATION = "select * from Genre";

    public GenreDAO(ProxyConnection pool) {

    }

    @Override
    public void findAll() {
        Statement statement = null;
        try{
            statement = pool.createStatement();
            ResultSet resultSet = statement.executeQuery(SHOW_ALL_INFORMATION);
            while(resultSet.next()){
                LOGGER.info(resultSet.getInt(1) + " " + resultSet.getBoolean(2) + " "
                        + resultSet.getBoolean(3) + " " + resultSet.getBoolean(4) + " "
                + resultSet.getBoolean(5) + " " + " " + resultSet.getBoolean(6) + " "
                        + resultSet.getBoolean(7) + " " + resultSet.getBoolean(8) + " "
                        + resultSet.getBoolean(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pool != null){
                close(statement);
                ConnectionPool.getInstance().releaseConnection(pool);
            }
        }
    }

    @Override
    public Entity findEntityById(int id) {
        return null;
    }

    @Override
    public void insert(Object... objects) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(String name, int id) {

    }
}
*/
