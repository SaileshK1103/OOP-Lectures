package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/currency_db";
    private static final String USER = "appuser";
    private static final String PASSWORD = "app_pass123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void main(String[] args) {
        try (Connection conn = MariaDbConnection.getConnection()) {
            System.out.println("Connected to DB successfully");
        }
        catch (SQLException e) {
            System.err.println("Connection failed: " +e.getMessage());
        }
    }
}
