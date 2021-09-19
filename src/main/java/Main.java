import users.ModelUsers;
import users.UsersService;
// todo разбей классы по пакетам, model это модели, repository это работа с б.д
// todo ветка должна называться не мастер а jdbc1, а вторая задаче вторая ветка jdbc2 в этом же проекте
public class Main {

    public static void main(String[] args) {

        ModelUsers user = new ModelUsers("Ivan", "Ivanov", 55);
        ModelUsers user1 = new ModelUsers("Petr", "Petrov", 36);
        ModelUsers user2 = new ModelUsers("Aleksei", "Alekseev", 43);
        ModelUsers user3 = new ModelUsers("Eclampiii", "Evlampiev", 36);
        ModelUsers users4 = new ModelUsers("Update","Updatov",99);


        JDBCConnection jdbcConnection = new JDBCConnection();//todo зачем здесь это если у тебя это происходит в каждом методе, это лишнее
        UsersService usersService = new UsersService();

        jdbcConnection.jdbcConnect();    // проверка соединения
//        usersService.createTableUser();
//        usersService.createTableUserAddress();
//        usersService.addUsers();          // добавление users в таблицу
//        usersService.addUsers1(user);
//        usersService.addUsers1(user1);
//        usersService.addUsers1(user2);
//        usersService.addUsers1(user3);
        usersService.updateUserInTable(users4);



//        usersService.updateTable();       // изменение по id
//        usersService.deleteUserInTable();   // удаление по id
//        usersService.deleteAllUserInTable();    // удаление всех users
//        usersService.getAllUsers();
//        usersService.getUsersById();

    }


}
