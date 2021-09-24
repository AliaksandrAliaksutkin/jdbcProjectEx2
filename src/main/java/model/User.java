package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id_user;
    private String firstName;
    private String lastName;
    private int age;
//todo корректней чтоб id адреса был у юзера, а не наоборот как у тебя

}
