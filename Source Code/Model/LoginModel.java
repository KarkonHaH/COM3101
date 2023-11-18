/**
 * This class is for the users login the system.
 */
package Model;

import Controller.LoginController;
import DTO.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    
    private static final String DB_NAME = "database.db";
    private Connection connection;
    
    private LoginController loginController;
    
    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    
    //create connection with SQL database
    public void createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    //close connection with SQL database
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User processLogin(String userId, String userPassword) { 
        User user = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE user_id = ? AND user_password = ?");
            pstmt.setString(1, userId);
            pstmt.setString(2, userPassword);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String userGroup = rs.getString("user_group");
                String gender = rs.getString("gender");
                String userName = rs.getString("user_name");
                user = new User(userId, userPassword, userGroup, gender, userName);
            }
            rs.close();
            pstmt.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}