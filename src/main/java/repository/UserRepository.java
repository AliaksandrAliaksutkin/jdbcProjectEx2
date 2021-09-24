package repository;
import model.Address;
import model.User;
import util.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class UserRepository {

    private static final Logger logger = Logger.getGlobal();

    public void createTableAddress() {

        try (Connection conn = DriverManager.getConnection(ConnectDB.URL.getConnectDB(),
                ConnectDB.USERNAME.getConnectDB(), ConnectDB.PASSWORD.getConnectDB())) {
            PreparedStatement preparedStatement = conn.prepareStatement("CREATE TABLE user_address (" +
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
            logger.info("User table created successfully!");

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
            preparedStatement.setString(1, String.valueOf(user.getId_user()));
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, String.valueOf(user.getId_address()));
            preparedStatement.addBatch();
            preparedStatement.executeUpdate();
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
            preparedStatement.addBatch();
            preparedStatement.executeUpdate();
            logger.info("Address have been successfully added to the table");

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
            logger.info("User deleted it tables successfully, in quantity.");

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
                    user.setId_usergit(UUID.fromString(resultSet.getString(1)));
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