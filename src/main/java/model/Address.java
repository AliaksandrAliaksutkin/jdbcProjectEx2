package model;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.UUID;

@Data
@AllArgsConstructor
public class Address {
    private UUID id_address;//todo переменные так нельзя называть, а так нужно называть колонки в бд везде глянь
    private String city;
    private String street;
    private Integer house;
    private UUID id_user;

}
