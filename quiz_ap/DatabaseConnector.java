package quiz_ap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/astrology_quiz"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "password"; 

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure MySQL JDBC Driver is loaded
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found. Ensure MySQL Connector JAR is added.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection testConnection = null;
        try {
            testConnection = DatabaseConnector.connect();
            if (testConnection != null) {
                System.out.println("Connection Test Successful!");
            } else {
                System.out.println("Connection Test Failed!");
            }
        } finally {
            // Ensure connection is closed to prevent resource leaks
            if (testConnection != null) {
                try {
                    testConnection.close();
                    System.out.println("Connection closed successfully.");
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
