/*
package com.epam.audiomanager.database.dao.impl;

import com.epam.audiomanager.database.dao.AbstractDAO;
import com.epam.audiomanager.entity.Entity;
import com.epam.audiomanager.database.pool.ConnectionPool;
import com.epam.audiomanager.database.pool.ProxyConnection;

import java.math.BigDecimal;
import java.sql.*;

public class AudioTrackDAO extends AbstractDAO {
    private static final String SHOW_ALL_INFORMATION = "select * from AudioTrack";
    private static final String INSERT_AUDIO_TRACK = "insert into AudioTrack(album_id, assembly_id, name, band, year, " +
            "price) values(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_NAME_FIRST = "update AudioTrack set name = \"";
    private static final String UPDATE_NAME_SECOND = "\" where id = ";

    public AudioTrackDAO(ProxyConnection pool) {

    }

    @Override
    public void findAll() {
        Statement statement = null;
        try{
            statement = pool.createStatement();
            ResultSet resultSet = statement.executeQuery(SHOW_ALL_INFORMATION);
            while(resultSet.next()){
                LOGGER.info(resultSet.getInt(1) + " " + resultSet.getInt(2) + " "
                        + resultSet.getInt(3) + " " + resultSet.getString(4) + " "
                + resultSet.getString(5) + " " + resultSet.getInt(6) + " "
                        + resultSet.getBigDecimal(7));
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
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = pool.prepareStatement(INSERT_AUDIO_TRACK);
            //preparedStatement.setInt(1, (Integer) objects[0]);
            if (objects[0] != null){
                preparedStatement.setInt(1, (Integer)objects[0]);
            } else {
                preparedStatement.setNull(1, 0);
            }
            if (objects[1] != null){
                preparedStatement.setInt(2, (Integer) objects[1]);
            } else {
                preparedStatement.setNull(2, 0);
            }
            preparedStatement.setString(3, String.valueOf(objects[2]));
            preparedStatement.setString(4, String.valueOf(objects[3]));
            preparedStatement.setInt(5, (Integer)objects[4]);
            preparedStatement.setBigDecimal(6, BigDecimal.valueOf((Double) objects[5]));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pool != null){
                close(preparedStatement);
                ConnectionPool.getInstance().releaseConnection(pool);
            }
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(String name, int id) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = pool.prepareStatement(UPDATE_NAME_FIRST + name + UPDATE_NAME_SECOND + id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pool != null){
                close(preparedStatement);
                ConnectionPool.getInstance().releaseConnection(pool);
            }
        }
    }
}
*/
