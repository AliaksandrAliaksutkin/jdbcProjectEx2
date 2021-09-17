import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCConnection {

     static final String USERNAME = "postgres";
     static final String PASSWORD = "821252";
     static final String HOST = "localhost";
     static final String PORT = "5432";
     static final String DBNAME = ("postgres");
     static final String URL = ("jdbc:postgresql://localhost:5432/postgres");


    public void jdbcConnection() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}







