import users.UsersService;

public class Main {

    public static void main(String[] args) {
        JDBCConnection jdbcConnection = new JDBCConnection();
        UsersService usersService = new UsersService();
        jdbcConnection.jdbcConnect();    // проверка соединения
//        usersService.createTable();         // создание таблицы
  //     usersService.addUsers();          // добавление users в таблицу
//        usersService.updateTable();       // изменение по id
//        usersService.deleteUserInTable();   // удаление по id
//        usersService.deleteAllUserInTable();    // удаление всех users
        usersService.getAllUsers();
        usersService.getUsersById();

    }
}