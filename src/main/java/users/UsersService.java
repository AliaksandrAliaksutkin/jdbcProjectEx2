package users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersService {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "821252";
    private static final String URL = ("jdbc:postgresql://localhost:5432/postgres");



                                            // создание таблицы user

    public void createTable() {
//
//        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
//            String sqlCommand = " CREATE TABLE user (id serial, " +
//                                "firstName varchar(20), " +
//                                "lastName varchar(20), " +
//                                "age int);";
//            Statement statement = conn.createStatement();
//            statement.executeUpdate(sqlCommand);
//
//            System.out.println("Database has been created!");
//
//        }catch (Exception ex) {
//            System.out.println("Connection failed...");
//
//            System.out.println(ex);
//        }
    }

                                            // добавление userОВ в таблицу (но не нашего класса ModelUsers)

   public void insertInto() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = conn.createStatement();
            statement.execute("""
                    INSERT INTO users1 (firstName,lastName,age)
                            VALUES  ( 'Michail', 'Zarubin',30),
                                     ( 'Dmitry', 'Prichep',34);""");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
   }
                                            // Изменение по id

   public void updateTable(){
       try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
           Statement statement = conn.createStatement();
           int rows = statement.executeUpdate("UPDATE users1 SET age = 55 WHERE id = 1");
           System.out.printf("Updated %d rows", rows);
           System.out.println("Database has been created!");

       }catch (Exception ex) {
           System.out.println("Connection failed...");

           System.out.println(ex);
       }

   }
                                            // удаление по id

public void deleteUserInTable(){
    try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
        Statement statement = conn.createStatement();
        int rows = statement.executeUpdate("DELETE FROM users1 WHERE id = 2");
        System.out.printf("Updated %d rows", rows);
        System.out.println("Database has been created!");

    }catch (Exception ex) {
        System.out.println("Connection failed...");

        System.out.println(ex);
    }
}

    public void deleteAllUserInTable(){
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("DELETE FROM users1");
            System.out.printf("Updated %d rows", rows);
            System.out.println("Database has been created!");

        }catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
