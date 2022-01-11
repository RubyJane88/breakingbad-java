package com.breakingbadspringboot.breakingbad.user.controller;

import com.breakingbadspringboot.breakingbad.user.dto.UserDto;
import com.breakingbadspringboot.breakingbad.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Log4j2
@AllArgsConstructor
@RestController
//@PreAuthorize("permitAll()")
public class UserController {

    private final UserService userService;

    //just for testing purposes
    @GetMapping("/api/vi/users")
    public Iterable<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    //GET USER BY ID
    @GetMapping("/api/vi/users/{id}")
    public UserDto getUserById(@PathVariable("id") UUID id) {
        return userService.findUserById(id);
    }

    //DELETE USER BY ID
    @GetMapping("/api/vi/users/delete/{id}")
    public void deleteUserById(@PathVariable("id") UUID id) {
        userService.removeUserById(id);
    }

    //REGISTER USER
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@RequestBody UserDto userDto) throws NoSuchAlgorithmException {
        return userService.createUser(userDto, userDto.getPassword());
    }

    //UPDATE USER BY ID
    @PutMapping("/api/v1/users/{id}")
    public void putUser(
            @PathVariable("id") UUID id,
            @Valid @RequestBody UserDto userDto
    ) throws NoSuchAlgorithmException {
        userService.updateUser(id, userDto, userDto.getPassword());
    }

}
