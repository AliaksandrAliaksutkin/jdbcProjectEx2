package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private UUID id_address;
    private String city;
    private String street;
    private Integer house;
    private UUID id_user;

}
