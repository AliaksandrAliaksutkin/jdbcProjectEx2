package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class JDBCConnection {

    public static void jdbcConnect() {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {

            if (conn != null) {
                System.out.println("Connected to the database!");    // todo здесь тоже логирование
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage()); // todo здесь тоже логирование
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}







