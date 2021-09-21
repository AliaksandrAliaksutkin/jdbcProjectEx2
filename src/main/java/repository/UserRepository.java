package repository;
import model.Address;
import model.User;
import util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserRepository {

    private static final Logger logger = Logger.getGlobal();


    // создание таблицы user

    public void createTableUser() {

        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            String sqlCommand = " CREATE TABLE user_table (id_user serial, " +
                    "firstName varchar(20), " +
                    "lastName varchar(20), " +
                    "age int):";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlCommand);
            logger.info("Database has been created!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createTableUserAddress() {

        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            String sqlCommand = " CREATE TABLE user_table (id_user serial, " +
                    "firstName varchar(20), " +
                    "lastName varchar(20), " +
                    "age int FOREIGN KEY (id_address) " +
                    "REFERENCES user_address (id_address) " +
                    "ON DELETE CASCADE);";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlCommand);
            logger.info("Database has been created!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // создание таблицы user_address

//    public void createTableAddress() {
//
//        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
//                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
//            String sqlCommand = " CREATE TABLE user_address (id_address serial, " +
//                    "city varchar(20), " +
//                    "street varchar(20), " +
//                    "house int);";
//
//            PreparedStatement preparedStatement = conn.prepareStatement(sqlCommand);
//            logger.info("Database has been created!");
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }



    public void addUserInTable(User users) {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {

            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO user_table (firstName, lastName, age) VALUES (?,?,?);");
            preparedStatement.setString(1, users.getFirstName());
            preparedStatement.setString(2, users.getLastName());
            preparedStatement.setInt(3, users.getAge());

            int rows = preparedStatement.executeUpdate();
            logger.info("User have been successfully added to the table");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


//    public void addAddressInTable(Address address) {
//        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
//                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
//
//            PreparedStatement preparedStatement =
//                    conn.prepareStatement("INSERT INTO user_address (city, street, house) VALUES (?,?,?);");
//            preparedStatement.setString(1, address.getCity());
//            preparedStatement.setString(2, address.getStreet());
//            preparedStatement.setInt(3, address.getHouse());
//
//            int rows = preparedStatement.executeUpdate();
//            logger.info("Address have been successfully added to the table");
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

    // получение всех юзеров

//    public List<User> getAllUsers() {
//        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
//                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
//            List<User> userList = new ArrayList<>();
//            try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM user_table");
//                 ResultSet resultSet = preparedStatement.executeQuery();) {
//                while (resultSet.next()) {
//                    User user = new User();
//                    int id_user = resultSet.getInt(1);
//                    user.setId(id_user);
//                    user.setFirstName(resultSet.getString(2));
//                    user.setLastName(resultSet.getString(3));
//                    user.setAge(resultSet.getInt(4));
//                    userList.add(user);
//                    logger.info("Users have been successfully added to userList");
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//            return userList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    // плучение по id

//    public User getUsersById() {
//        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
//                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
//            User user = null;
//            try {
//                PreparedStatement preparedStatement = conn.prepareStatement("SELECT*FROM user_table WHERE id=6");
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    user = new User();
//                    int id_user = resultSet.getInt(1);
//                    user.setId(id_user);
//                    user.setFirstName(resultSet.getString(2));
//                    user.setLastName(resultSet.getString(3));
//                    user.setAge(resultSet.getInt(4));
//
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//            return user;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//            return null;
//    }

    // Изменение по id

//    public void updateUserInTable(User users){
//       try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
//               ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
//           PreparedStatement preparedStatement =
//                   conn.prepareStatement("UPDATE user_table SET firstName=?, lastName=?, age=? WHERE id_user = 2");
//           preparedStatement.setString(1, users.getFirstName());
//           preparedStatement.setString(2,users.getLastName());
//           preparedStatement.setInt(3, users.getAge());
//
//           int rows = preparedStatement.executeUpdate();
//           logger.info("user state changed successfully, in quantity: " + rows);
//
//
//       } catch (SQLException ex) {
//           ex.printStackTrace();
//       }
//
//   }

   // удаление по id

//    public void deleteUserInTableById(){
//    try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
//            ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
//        PreparedStatement preparedStatement =
//                conn.prepareStatement("DELETE FROM user_table WHERE id_user = 2");
//        int rows = preparedStatement.executeUpdate();
//        logger.info("User deleted it tables successfully, in quantity: " + rows);
//
//    }catch (Exception ex) {
//      ex.printStackTrace();
//    }
//}

    public void deleteUserForAddressInTableById(){
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("DELETE FROM user_address WHERE id_address = 1");
            int rows = preparedStatement.executeUpdate();
            logger.info("User deleted it tables successfully, in quantity: " + rows);

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
                logger.info("Users deleted it tables successfully, in quantity: " + rows);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

}

