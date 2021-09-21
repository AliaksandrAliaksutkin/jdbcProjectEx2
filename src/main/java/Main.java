import model.Address;
import model.User;
import repository.UserRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user = new User("Ivan", "Ivanov", 55);
        Address address = new Address("Beryoza", "Lenina", 13);
        User user1 = new User("Petr", "Petrov", 36);
        Address address1 = new Address("Beryoza", "Komsomolskaya", 23);
        User user2 = new User("Aleksei", "Alekseev", 43);
        Address address2 = new Address("Beloozersk", "Pobedy", 13);
        User user3 = new User("Eclampiii", "Evlampiev", 36);
        Address address3 = new Address("Beloozersk", "Kutuzova", 53);
//        User users4 = new User("Update","Updatov",99);
//        Address address4 = new Address("Brest", "Ochakava", 903);


        UserRepository userRepository = new UserRepository();
//
        userRepository.createTableUser();
//        userRepository.createTableAddress();
//        userRepository.createTableUserAddress();


//        userRepository.addUserInTable(user);
//        userRepository.addUserInTable(user1);
//        userRepository.addUserInTable(user2);
//        userRepository.addUserInTable(user3);
//        userRepository.addAddressInTable(address);
//        userRepository.addAddressInTable(address1);
//        userRepository.addAddressInTable(address2);
//        userRepository.addAddressInTable(address3);
//

//        userRepository.updateUserInTable(users4);

//        userRepository.deleteUserInTableById();
//        userRepository.deleteAllUserInTable();
//        userRepository.deleteUserForAddressInTableById();

//        userRepository.getAllUsers();
//        List<User> userList = userRepository.getAllUsers();
//        System.out.println(userList);

//        userRepository.getUsersById();
//        user = userRepository.getUsersById();
//        System.out.println(user);

    }


}
