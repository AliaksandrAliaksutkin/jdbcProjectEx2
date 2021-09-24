package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class JDBCConnection {

    private static final Logger logger = Logger.getLogger("util.JDBCConnection");

    public static void jdbcConnect() {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {

            if (conn != null) {
                logger.info("Connected to the database!");
            } else {
                logger.info("Failed to make connection!");
            }

        } catch (SQLException e) {
            logger.info(e.getSQLState() + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







