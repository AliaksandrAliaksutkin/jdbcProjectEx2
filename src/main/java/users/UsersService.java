package users;
import java.sql.*;

public class UsersService {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "821252";
    private static final String URL = ("jdbc:postgresql://localhost:5432/postgres");



                                            // создание таблицы user

    public void createTableUser() {

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sqlCommand = " CREATE TABLE user_table (id serial, " +
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

                                                                        // создание таблицы user_address
    public void createTableUserAddress() {

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sqlCommand = " CREATE TABLE user_address (id serial, " +
                    "city varchar(20), " +
                    "street varchar(20), " +
                    "house int);";
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
//        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
//            Statement statement = conn.createStatement();
//            statement.execute("""
//                    INSERT INTO user_table (firstName,lastName,age)
//                            VALUES  ( 'Michail', 'Zarubin',30),
//                                     ( 'Dmitry', 'Prichep',34);""");
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
   }

    public void addUsers1(ModelUsers users) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO user_table (firstName, lastName, age) VALUES (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);//todo его используй везде, а то где-то обычный statement, почитай почему он лучше
            preparedStatement.setString(1, users.getFirstName());
            preparedStatement.setString(2,users.getLastName());
            preparedStatement.setInt(3, users.getAge());

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


                                            // получение всех юзеров

    public void getAllUsers() { //todo почему а почему метод который получает всех юзер ничего не возвращает? логично что он должен вернуть всех пользователей
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
        System.out.println("Connection failed...");//todo это что-то лишнее, просто бросай ex.printStackTace... и везде так

        System.out.println(ex);
    }
}
                                // плучение по id

    public void getUsersById() {//todo тоже что и выше, должен что-то вернуть
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

   public void updateUserInTable(ModelUsers users){
       try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
           String sql = "UPDATE user_table SET firstName=?, lastName=?, age=? WHERE id = 2";
           PreparedStatement preparedStatement = conn.prepareStatement(sql);
           preparedStatement.setString(1, users.getFirstName());
           preparedStatement.setString(2,users.getLastName());
           preparedStatement.setInt(3, users.getAge());

           int rows = preparedStatement.executeUpdate();
           System.out.println(rows);

       } catch (SQLException throwables) {
           throwables.printStackTrace();
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
