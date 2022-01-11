package com.breakingbadspringboot.breakingbad.user.dto;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
     private UUID id;
    private String email;
    private String mobileNumber;
    private String password;
}
