import model.User;
import model.UserRepository;

import java.util.List;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        User user = new User("Ivan", "Ivanov", 55);
        User user1 = new User("Petr", "Petrov", 36);
        User user2 = new User("Aleksei", "Alekseev", 43);
        User user3 = new User("Eclampiii", "Evlampiev", 36);
        User users4 = new User("Update","Updatov",99);


        UserRepository userRepository = new UserRepository();

        userRepository.createTableUser();
        userRepository.createTableUserAddress();
        userRepository.addUserInTable(user);
        userRepository.addUserInTable(user1);
        userRepository.addUserInTable(user2);
        userRepository.addUserInTable(user3);
        userRepository.updateUserInTable(users4);
        userRepository.deleteUserInTableById();
        userRepository.deleteAllUserInTable();

        userRepository.getAllUsers();
        List<User> userList = userRepository.getAllUsers();
        System.out.println(userList);

        userRepository.getUsersById();
        user = userRepository.getUsersById();
        System.out.println(user);

    }


}
