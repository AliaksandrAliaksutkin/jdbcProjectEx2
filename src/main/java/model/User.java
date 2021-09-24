package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID idUser;
    private String firstName;
    private String lastName;
    private int age;
    private UUID idAddress;

}
