package users;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "821252";

    public static void main(String[] args) {
        Connection connection;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try { connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
//            statement.execute("CREATE TABLE users(, id Integer, firstName varchar,lastName varchar, age int");
            statement.execute("""
                    INSERT INTO users (id, firstName,lastName,age)
                            VALUES  (1, 'Aliaksandr', 'Aliakutkin',33),
                                     (3, 'Aliaksandr', 'Lazovskii',31),
                                     (2, 'Aliaksandr', 'Dyshko',30),
                                     (4, 'Dmitry', 'Ykushik',32);""");

        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвера");
        }
    }
}
