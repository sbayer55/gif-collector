package com.tesseractus.gifcollector.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
