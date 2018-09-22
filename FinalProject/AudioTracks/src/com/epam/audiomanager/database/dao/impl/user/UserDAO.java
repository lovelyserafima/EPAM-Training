package com.epam.audiomanager.database.dao.impl.user;

import com.epam.audiomanager.database.dao.AbstractDAO;
import com.epam.audiomanager.database.pool.ConnectionPool;
import com.epam.audiomanager.entity.Entity;
import com.epam.audiomanager.entity.user.Client;
import com.epam.audiomanager.entity.user.Sex;
import com.epam.audiomanager.entity.user.TypeUser;
import com.epam.audiomanager.entity.user.User;
import com.epam.audiomanager.exception.ProjectException;
import java.sql.*;

public class UserDAO extends AbstractDAO implements UserDAOImpl {
    //database queries
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD = "select * from User where email = ? and password = ?";
    private static final String FIND_USER_BY_EMAIL = "select * from User where email = ?";
    private static final String FIND_USER_BY_LOGIN = "select * from User where login = ?";
    private static final String FIND_CLIENT_BY_ID = "select * from Client where user_id = ?";
    private static final String FIND_ALL = "select * from User";

    private static final String INSERT_USER = "insert into User(login, password, role, first_name, second_name, email) " +
            "values(?, ?, ?, ?, ?, ?)";
    private static final String INSERT_CLIENT = "insert into Client(bonus) values(?)";
    private static final String ADMIN = "ADMIN";

    public UserDAO(){}

    @Override
    public User findUserByEmailAndPassword(String email, String password) throws ProjectException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                if (resultSet.getString(4).toUpperCase().equals(ADMIN)){
                    return createUser(resultSet);
                } else {
                    PreparedStatement preparedStatementForClient = connection.prepareStatement(FIND_CLIENT_BY_ID);
                    preparedStatementForClient.setInt(1, resultSet.getInt(1));
                    ResultSet resultSetForClient = preparedStatementForClient.executeQuery();
                    if (resultSetForClient.next()){
                        return createClient(resultSet, resultSetForClient);
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
            throw new ProjectException("SQLException", e);
        } finally {
            if (connection != null){
                close(preparedStatement);
                ConnectionPool.getInstance().releaseConnection(connection);
            }
        }
        return null;
    }

    @Override
    public User findUserByEmail(String email) throws ProjectException {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return null;
            }
        } catch (SQLException e) {
            LOGGER.error("Error with searching user by email", e);
            throw new ProjectException("Error with searching user by email", e);
        } finally {
            if (connection != null){
                close(preparedStatement);
                ConnectionPool.getInstance().releaseConnection(connection);
            }
        }
        return null;
    }

    @Override
    public User findUserByLogin(String login) throws ProjectException {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return null;
            }
        } catch (SQLException e) {
            LOGGER.error("Error with searching user by login", e);
            throw new ProjectException("Error with searching user by login", e);
        } finally {
            if (connection != null){
                close(preparedStatement);
                ConnectionPool.getInstance().releaseConnection(connection);
            }
        }
        return null;
    }

    private User createUser(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getInt(1), resultSet.getString(2),
                TypeUser.valueOf(resultSet.getString(4).toUpperCase()),
                resultSet.getString(5), resultSet.getString(6),
                resultSet.getString(7));
    }

    private Client createClient(ResultSet resultSet, ResultSet resultSetForClient) throws SQLException {
        return new Client(resultSet.getInt(1), resultSet.getString(2),
                TypeUser.valueOf(resultSet.getString(4).toUpperCase()),
                resultSet.getString(5), resultSet.getString(6),
                resultSet.getString(7), resultSetForClient.getBoolean(2));
    }

    public void insert(User user, String encryptedPassword) throws ProjectException {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, encryptedPassword);
            preparedStatement.setString(3, String.valueOf(user.getType()));
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getSecondName());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.executeUpdate();
            if (user.getType() == TypeUser.CLIENT){
                PreparedStatement preparedStatementForClient = connection.prepareStatement(INSERT_CLIENT);
                preparedStatementForClient.setBoolean(1, ((Client) user).isBonus());
                preparedStatementForClient.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error("Error with registration new client", e);
            throw new ProjectException("Error with registration new client", e);
        } finally {
            if (connection != null){
                close(preparedStatement);
                ConnectionPool.getInstance().releaseConnection(connection);
            }
        }
    }

    @Override
    public void findAll() throws ProjectException {
        /*try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + resultSet.getString(2) + resultSet.getString(3) +
                        TypeUser.valueOf(resultSet.getString(4).toUpperCase()) +
                        resultSet.getString(5) + resultSet.getString(6) +
                        Sex.valueOf(resultSet.getString(7).toUpperCase()) +  resultSet.getInt(8) +
                        resultSet.getString(9) + resultSet.getString(10) +
                        resultSet.getString(11));
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
            throw new ProjectException("SQLException", e);
        }*/
    }
}