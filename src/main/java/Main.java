import model.Address;
import model.User;
import repository.UserRepository;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {


        UUID uuid = UUID.randomUUID();
        User user = new User(UUID.randomUUID(),"Ivan", "Ivanov", 55,uuid);
        Address address = new Address(uuid, "Beryza", "Lenina", 13);

        UUID uuid1 = UUID.randomUUID();
        User user1 = new User(UUID.randomUUID(),"Petr", "Petrov", 36,uuid1);
        Address address1 = new Address(uuid1,"Beryoza", "Komsomolskaya", 23);

        UUID uuid2 = UUID.randomUUID();
        User user2 = new User(UUID.randomUUID(),"Aleksei", "Alekseev", 43,uuid2);
        Address address2 = new Address(uuid2,"Beloozersk", "Pobedy", 13);

        UUID uuid3 = UUID.randomUUID();
        User user3 = new User(UUID.randomUUID(), "Evlampiii", "Evlampiev", 36,uuid3);
        Address address3 = new Address(uuid3,"Beloozersk", "Kutuzova", 53);

        UserRepository userRepository = new UserRepository();

//        userRepository.createTableUserForAddress();
//        userRepository.createTableUser();

//        userRepository.addTables(user,address);
//        userRepository.addTables(user1,address1);
//        userRepository.addTables(user2,address2);
//        userRepository.addTables(user3,address3);

//        userRepository.deleteAllUserInTable();
//        userRepository.deleteUserForAddressInTableById();

    }

}
