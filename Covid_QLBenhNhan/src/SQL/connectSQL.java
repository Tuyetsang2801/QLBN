package SQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectSQL {
    public static Connection getConnection() throws SQLException {
        Connection c = null;
        try {
            String url = "jdbc:mysql://localhost:3306/sang";
            String userName = "root";
            String password = "0728012004";
            // No need to explicitly register the driver for JDBC 4.0 and later

            // Try-with-resources ensures proper resource management
            c = DriverManager.getConnection(url, userName, password);
            System.out.println("Ket noi thanh cong den CSDL");
        } catch (SQLException e) {
            // Log or print a more meaningful error message
            e.printStackTrace();
            throw e; // Rethrow the exception to indicate that the connection failed
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            // Log or print a more meaningful error message
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            // Log or print a more meaningful error message
            e.printStackTrace();
        }
    }
}
