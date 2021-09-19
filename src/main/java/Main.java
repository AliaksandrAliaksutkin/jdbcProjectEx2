import model.User;
import model.UserRepository;

import java.util.List;

// todo ветка должна называться не мастер а jdbc1, а вторая задаче вторая ветка jdbc2 в этом же проекте
public class Main {

    public static void main(String[] args) {

        User user = new User("Ivan", "Ivanov", 55);
        User user1 = new User("Petr", "Petrov", 36);
        User user2 = new User("Aleksei", "Alekseev", 43);
        User user3 = new User("Eclampiii", "Evlampiev", 36);
        User users4 = new User("Update","Updatov",99);

        UserRepository userRepository = new UserRepository();

//        usersService.createTableUser();
//        usersService.createTableUserAddress();
//        usersService.addUsers();          // добавление users в таблицу
//        usersService.addUsers1(user);
//        usersService.addUsers1(user1);
//        usersService.addUsers1(user2);
//        usersService.addUsers1(user3);
//        userRepository.updateUserInTable(users4);



//        usersService.updateTable();       // изменение по id
//        usersService.deleteUserInTable();   // удаление по id
//        userRepository.deleteAllUserInTable();    // удаление всех users

//            userRepository.getAllUsers();
//            List<User> userList = userRepository.getAllUsers();
//            System.out.println(userList);

        userRepository.getUsersById();
        user = userRepository.getUsersById();
        System.out.println(user);

    }


}
