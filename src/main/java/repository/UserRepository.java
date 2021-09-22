package repository;
import model.Address;
import model.User;
import util.ConnectDB;
import java.sql.*;
import java.util.logging.Logger;

public class UserRepository {

    private static final Logger logger = Logger.getGlobal();

    public void createTableUser() {

        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            String nameTable = "user";
            String sqlCommand = "CREATE TABLE " + nameTable + "(" +
                    "id_user varchar PRIMARY KEY," +
                    "firstName varchar," +
                    "lastName varchar," +
                    "age integer, " +
                    "id_address varchar, " +
                    "FOREIGN KEY (id_address)" +
                    "REFERENCES user_address (id_address)" +
                    "ON DELETE CASCADE);";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlCommand);
            preparedStatement.executeUpdate();
            logger.info("User table created successfully!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createTableAddress() {

        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            PreparedStatement preparedStatement = conn.prepareStatement( "CREATE TABLE user_address (" +
                    "id_address varchar PRIMARY KEY, " +
                    "city varchar," +
                    "street varchar, " +
                    "house integer);");
            preparedStatement.executeUpdate();
            logger.info("Address table created successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addTables(User user, Address address){
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {

            String addUser = "INSERT INTO user (id_user ,first_name, last_name, age, id_adress) VALUES  (?,?,?,?,?)";
            String addAddress = " INSERT INTO user_address (id_adress, city, street, house) VALUES (?,?,?,?)";

            addUserInTable(user, addUser);
            addAddressInTable(address,addAddress);
            logger.info("User have been successfully added to the table");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addUserInTable(User user, String addUser) {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {

            PreparedStatement preparedStatement =
                    conn.prepareStatement(addUser);
            preparedStatement.setString(1, String.valueOf(user.getId_user()));
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5,String.valueOf(user.getId_address()));
            // Запрос не выполняется, а укладывается в буфер,
            //  который потом выполняется сразу для всех команд
            preparedStatement.addBatch();
            // Выполняем все запросы разом
            preparedStatement.executeBatch();
            logger.info("User have been successfully added to the table");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addAddressInTable(Address address, String addAddress) {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {

            PreparedStatement preparedStatement =
                    conn.prepareStatement(addAddress);
            preparedStatement.setString(1, String.valueOf(address.getId_address()));
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setInt(4, address.getHouse());
            // Запрос не выполняется, а укладывается в буфер,
            //  который потом выполняется сразу для всех команд
            preparedStatement.addBatch();
            // Выполняем все запросы разом
            preparedStatement.executeBatch();
            logger.info("Address have been successfully added to the table");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


//    public void deleteUserForAddressInTableById(){
//        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
//                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
//            PreparedStatement preparedStatement =
//                    conn.prepareStatement("DELETE FROM user_address WHERE id_address = 2");
//            int rows = preparedStatement.executeUpdate();
//            logger.info("User deleted it tables successfully, in quantity: " + rows);
//
//        }catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void deleteAllUserInTable () {
//            try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
//                    ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
//                PreparedStatement preparedStatement =
//                        conn.prepareStatement("DELETE FROM user_address");
//                int rows = preparedStatement.executeUpdate();
//                logger.info("Users deleted it tables successfully, in quantity: " + rows);
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }

}

