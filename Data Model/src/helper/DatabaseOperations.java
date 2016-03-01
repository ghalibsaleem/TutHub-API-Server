package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ghali on 2/10/2016.
 */
public class DatabaseOperations {
    private static final String databaseString = "jdbc:mysql://localhost:3308/tut_hub_server_db?";
    private static final String dBUsername = "root";
    private static final String dBPassword = "1234";
    private static Connection connection = null;

    protected static Connection getConnection() {
        if (connection == null)
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(databaseString +
                        "user=" + dBUsername + "&password=" + dBPassword);

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        return connection;

    }

    protected static boolean isConnectionActive() {
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected static void stopConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
