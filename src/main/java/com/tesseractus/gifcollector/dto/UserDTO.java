package com.tesseractus.gifcollector.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
