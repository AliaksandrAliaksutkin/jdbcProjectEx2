package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Address {
    private UUID id_address;
    private String city;
    private String street;
    private Integer house;

}
