import model.Address;
import model.User;
import repository.UserRepository;

public class Main {

    public static void main(String[] args) {

//        User user = new User("Ivan", "Ivanov", 55);
//        Address address = new Address("Beryoza", "Lenina", 13);
//        User user1 = new User("Petr", "Petrov", 36);
//        Address address1 = new Address("Beryoza", "Komsomolskaya", 23);
//        User user2 = new User("Aleksei", "Alekseev", 43);
//        Address address2 = new Address("Beloozersk", "Pobedy", 13);
//        User user3 = new User("Eclampiii", "Evlampiev", 36);
//        Address address3 = new Address("Beloozersk", "Kutuzova", 53);

        UserRepository userRepository = new UserRepository();

//        userRepository.createTableUserForAddress();
        userRepository.createTableUser();

//        userRepository.addTables(user,address);
//        userRepository.addTables(user1,address1);
//        userRepository.addTables(user2,address2);
//        userRepository.addTables(user3,address3);

//        userRepository.deleteAllUserInTable();
//        userRepository.deleteUserForAddressInTableById();

    }

}
