package users;
import java.sql.*;

public class UsersService {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "821252";
    private static final String URL = ("jdbc:postgresql://localhost:5432/postgres");



                                            // создание таблицы user

    public void createTable() {

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sqlCommand = " CREATE TABLE user (id serial, " +
                                "firstName varchar(20), " +
                                "lastName varchar(20), " +
                                "age int);";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlCommand);

            System.out.println("Database has been created!");

        }catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

                                            // добавление userОВ в таблицу (но не нашего класса ModelUsers)

   public void addUsers() {
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


                                            // получение всех юзеров

    public void getAllUsers() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users1");
            while(resultSet.next()){

                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                System.out.println("id: "+ id + ", firstName: " + firstName+ ", lastName: " +lastName+ ", age: " +age+";");

            }
        }
     catch(Exception ex){
        System.out.println("Connection failed...");

        System.out.println(ex);
    }
}

                                                                //

    public void getUsersById() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT*FROM users1 WHERE id=11");
            while(resultSet.next()){

                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                System.out.println("id: "+ id + ", firstName: " + firstName+ ", lastName: " +lastName+ ", age: " +age+";");

            }
        } catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
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
