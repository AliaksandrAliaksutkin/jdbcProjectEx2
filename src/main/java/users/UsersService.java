package users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersService {
    static final String USERNAME = "postgres";
    static final String PASSWORD = "821252";
    static final String URL = ("jdbc:postgresql://localhost:5432/postgres");

    public void insertInto() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = conn.createStatement();
            statement.execute("""
                    INSERT INTO users (firstName,lastName,age)
                            VALUES  ( 'Michail', 'Zarubin',30),
                                     ( 'Dmitry', 'Prichep',34);""");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
