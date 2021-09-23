import model.Address;
import model.User;
import repository.UserRepository;
import util.ConnectDB;

import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {


        UUID uuid = UUID.randomUUID();
        UUID uuid11 = UUID.randomUUID();
        User user = new User (uuid,"Ivan", "Ivanov", 55);
        Address address = new Address(uuid11, "Beryza", "Lenina", 13,uuid);

        UUID uuid1 = UUID.randomUUID();
        UUID uuid21 = UUID.randomUUID();
        User user1 = new User (uuid1,"Petr", "Petrov", 36);
        Address address1 = new Address(uuid21,"Beryoza", "Komsomolskaya", 23,uuid1);

        UUID uuid2 = UUID.randomUUID();
        UUID uuid31 = UUID.randomUUID();
        User user2 = new User(uuid2,"Aleksei", "Alekseev", 43);
        Address address2 = new Address(uuid31,"Beloozersk", "Pobedy", 13,uuid2);

        UUID uuid3 = UUID.randomUUID();
        UUID uuid41 = UUID.randomUUID();
        User user3 = new User(uuid3, "Evlampiii", "Evlampiev", 36);
        Address address3 = new Address(uuid41,"Beloozersk", "Kutuzova", 53,uuid3);

        UserRepository userRepository = new UserRepository();

//        userRepository.createTableUser();
//        userRepository.createTableAddress();

//        userRepository.addTables(user, address);
//        userRepository.addTables(user1,address1);
//        userRepository.addTables(user2,address2);
//        userRepository.addTables(user3,address3);
//
//        userRepository.deleteUserById(uuid2);

        List<User> list = userRepository.getUserByHouse(address2.getHouse());
        System.out.println(list);

    }

}
