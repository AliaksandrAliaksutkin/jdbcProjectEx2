package model;
import repository.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class UserRepository {

    // создание таблицы user

    public void createTableUser() {

        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            String sqlCommand = " CREATE TABLE user_table (id serial, " +
                    "firstName varchar(20), " +
                    "lastName varchar(20), " +
                    "age int);";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlCommand);

            System.out.println("Database has been created!");               // log???

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // создание таблицы user_address

    public void createTableUserAddress() {

        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            String sqlCommand = " CREATE TABLE user_address (id serial, " +
                    "city varchar(20), " +
                    "street varchar(20), " +
                    "house int);";

            PreparedStatement preparedStatement = conn.prepareStatement(sqlCommand);

            System.out.println("Database has been created!");                       //todo сделай логирование везде где есть вывод

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addUserInTable(User users) {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {

            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO user_table (firstName, lastName, age) VALUES (?,?,?)");
            preparedStatement.setString(1, users.getFirstName());
            preparedStatement.setString(2, users.getLastName());
            preparedStatement.setInt(3, users.getAge());

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows);                           //log???

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // получение всех юзеров

    public List<User> getAllUsers() {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            List<User> userList = new ArrayList<>();
            try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM user_table");
                 ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    User user = new User();
                    int id = resultSet.getInt(1);
                    user.setId(id);
                    user.setFirstName(resultSet.getString(2));
                    user.setLastName(resultSet.getString(3));
                    user.setAge(resultSet.getInt(4));
                    userList.add(user);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // плучение по id

    public User getUsersById() {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            User user = null;
            try {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT*FROM user_table WHERE id=6");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    user = new User();
                    int id = resultSet.getInt(1);
                    user.setId(id);
                    user.setFirstName(resultSet.getString(2));
                    user.setLastName(resultSet.getString(3));
                    user.setAge(resultSet.getInt(4));

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;
    }

    // Изменение по id

    public void updateUserInTable(User users){
       try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
               ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
           PreparedStatement preparedStatement =
                   conn.prepareStatement("UPDATE user_table SET firstName=?, lastName=?, age=? WHERE id = 2");
           preparedStatement.setString(1, users.getFirstName());
           preparedStatement.setString(2,users.getLastName());
           preparedStatement.setInt(3, users.getAge());

           int rows = preparedStatement.executeUpdate();
           System.out.println(rows);

       } catch (SQLException ex) {
           ex.printStackTrace();
       }

   }

   // удаление по id

    public void deleteUserInTableById(){
    try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
            ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
        PreparedStatement preparedStatement =
                conn.prepareStatement("DELETE FROM user_table WHERE id = 2");
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows);

    }catch (Exception ex) {
      ex.printStackTrace();
    }
}

    public void deleteAllUserInTable () {
            try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                    ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
                PreparedStatement preparedStatement =
                        conn.prepareStatement("DELETE FROM user_table");
                int rows = preparedStatement.executeUpdate();
                System.out.println(rows);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

}

