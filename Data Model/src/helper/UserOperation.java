package helper;

import models.User;

import java.sql.*;
import java.util.List;

/**
 * Created by ghalib on 2/10/2016.
 */
public class UserOperation {
    private Connection connection = null;
    private Statement statement = null;

    public UserOperation() {
        connection = DatabaseOperations.getConnection();
    }

    public boolean userLogin(String username, String password) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            if (username.contains("@"))
                rs = stmt.executeQuery("select * from users WHERE email='" + username + "' AND password='" + password+"''");
            else
                rs = stmt.executeQuery("select * from users WHERE username='" + username + "' AND password='" + password+"'");
            if (rs != null && rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void createConnection(){

        try {
            if (connection == null || connection.isClosed())
                connection = DatabaseOperations.getConnection();
            if (statement ==null || statement.isClosed())
                statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void terminateConnection(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String username, String password) {
        createConnection();
        try {


            ResultSet rs = null;
            if (username.contains("@"))
                rs = statement.executeQuery("select * from users WHERE email='" + username + "' AND password='" + password+"'");
            else
                rs = statement.executeQuery("select * from users WHERE username='" + username + "' AND password='" + password+"'");
            if (rs != null && rs.next()) {
                User user = new User(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getInt(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9)
                );

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            terminateConnection();
        }
        return null;
    }

    public User updateUser(User user){
        createConnection();
        try {
            ResultSet rs = statement.executeQuery("select * from users WHERE username='" + user.getUsername() + "' AND password='" + user.getPassword()+"'");
            // TODO: 2/27/2016
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            terminateConnection();
        }
        return null;
    }
    
    public User addUser(User user){
        // TODO: 2/26/2016  
        return user;
    }
    
    public boolean deleteUser(User user){
        createConnection();
        try{
            boolean result = statement.execute("DELETE FROM users WHERE username = '"+user.getUsername()+"' AND password = '"+user.getPassword()+"'");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            terminateConnection();
        }
        return true;
    }

    public List<String> findUser(String subString){

        return null;
    }
}
