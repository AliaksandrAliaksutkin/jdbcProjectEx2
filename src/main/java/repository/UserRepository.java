package repository;
import lombok.extern.log4j.Log4j2;
import model.Address;
import model.User;
import util.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.extern.java.Log;


@Log
public class UserRepository {

    public void createTableAddress() {

        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            PreparedStatement preparedStatement = conn.prepareStatement("CREATE TABLE user_address (" +
                    "id_address varchar PRIMARY KEY, " +
                    "city varchar," +
                    "street varchar, " +
                    "house integer);");
            preparedStatement.executeUpdate();
            log.info("Address table created successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createTableUser() {

        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            PreparedStatement preparedStatement = conn.prepareStatement("CREATE TABLE   users  " +
                    "(id_user varchar PRIMARY KEY," +
                    "firstName varchar," +
                    "lastName varchar," +
                    "age integer, " +
                    "id_address varchar REFERENCES user_address (id_address) ON DELETE CASCADE);");
            preparedStatement.executeUpdate();
            log.info("User table created successfully!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addTables(User user, Address address) {

        String addUser = "INSERT INTO users (id_user ,firstName, lastName, age, id_address) VALUES  (?,?,?,?,?)";
        String addAddress = " INSERT INTO user_address (id_address, city, street, house) VALUES (?,?,?,?)";

        addAddressInTable(address, addAddress);
        addUserInTable(user, addUser);

    }

    public void addUserInTable(User user, String addUser) {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {

            PreparedStatement preparedStatement = conn.prepareStatement(addUser);
            preparedStatement.setString(1, String.valueOf(user.getIdUser()));
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, String.valueOf(user.getIdAddress()));
            preparedStatement.addBatch();
            preparedStatement.executeUpdate();
            log.info("User have been successfully added to the table");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addAddressInTable(Address address, String addAddress) {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {

            PreparedStatement preparedStatement =
                    conn.prepareStatement(addAddress);

            preparedStatement.setString(1, String.valueOf(address.getIdAddress()));
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setInt(4, address.getHouse());
            preparedStatement.addBatch();
            preparedStatement.executeUpdate();
            log.info("Address have been successfully added to the table");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void deleteUserById(UUID uuid) {
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {

            PreparedStatement preparedStatement =
                    conn.prepareStatement("DELETE FROM user_address WHERE id_address = ?");
            preparedStatement.setString(1,uuid.toString());
            preparedStatement.executeUpdate();
            log.info("User deleted it tables successfully, in quantity.");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<User> getUserByHouse(Integer house) {
        List<User> usersList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM user_address WHERE house = " + house);
            ResultSet resultSet = preparedStatement.executeQuery();
            try {
                while (resultSet.next()) {
                    User user = new User();
                    user.setIdUser(UUID.fromString(resultSet.getString(1)));
                    user.setFirstName(resultSet.getString(2));
                    user.setLastName(resultSet.getString(3));
                    user.setAge(resultSet.getInt(4));
                    usersList.add(user);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return usersList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            return usersList;
    }
}
