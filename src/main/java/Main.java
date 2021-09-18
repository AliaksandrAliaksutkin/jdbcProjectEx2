import users.UsersService;

public class Main {

    public static void main(String[] args) {
        JDBCConnection jdbcConnection = new JDBCConnection();
        UsersService usersService = new UsersService();
        jdbcConnection.jdbcConnection();    // проверка соединения
//        usersService.createTable();         // создание таблицы
//        usersService.insertInto();          // добавление users в таблицу
//        usersService.updateTable();       // изменение по id
//        usersService.deleteUserInTable();   // удаление по id
        usersService.deleteAllUserInTable();


    }
}