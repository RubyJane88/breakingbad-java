package com.breakingbadspringboot.breakingbad.user.service;

import com.breakingbadspringboot.breakingbad.exception.BadRequestException;
import com.breakingbadspringboot.breakingbad.exception.NotFoundException;
import com.breakingbadspringboot.breakingbad.user.dto.UserDto;
import com.breakingbadspringboot.breakingbad.user.entity.UserEntity;
import com.breakingbadspringboot.breakingbad.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserEntity searchByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserDto> findAllUsers() {

        var userEntityList = new LinkedList<>(userRepository.findAll());

        return userEntityList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDto findUserById(final UUID id) {
        var user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found")
        );
        return convertToDto(user);
    }

    //CREATE USER
    public UserDto createUser(UserDto userDto, String password)
            throws NoSuchAlgorithmException {
        var user = convertToEntity(userDto);

        if (password.isBlank()) throw new IllegalArgumentException(
                "Password is required"
        );

        var existsEmail = userRepository.selectExistsEmail(user.getEmail());
        if (existsEmail) throw new BadRequestException(
                "Email is taken"
        );

        byte[] salt = createSalt();
        byte[] hashedPassword = createPasswordHash(password, salt);

        user.setStoredSalt(salt);
        user.setStoredHash(hashedPassword);

        userRepository.save(user);

        return convertToDto(user);
    }

    //UPDATE USER
    public void updateUser(UUID id, UserDto userDto, String password)
            throws NoSuchAlgorithmException {
        var user = findOrThrow(id);
        var userParam = convertToEntity(userDto);

        user.setEmail(userParam.getEmail());
        user.setMobileNumber(userParam.getMobileNumber());

        if (!password.isBlank()) {
            byte[] salt = createSalt();
            byte[] hashedPassword = createPasswordHash(password, salt);

            user.setStoredSalt(salt);
            user.setStoredHash(hashedPassword);
        }

        userRepository.save(user);
    }


    // READ USER
    public void removeUserById(UUID id) {
        findOrThrow(id);
        userRepository.deleteById(id);
    }


    //CREATE SALT AND PASSWORD HASH

    private byte[] createSalt() {
        var random = new SecureRandom();
        var salt = new byte[128];
        random.nextBytes(salt);

        return salt;
    }

    private byte[] createPasswordHash(String password, byte[] salt)
            throws NoSuchAlgorithmException {
        var md = MessageDigest.getInstance("SHA-512");
        md.update(salt);

        return md.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    private UserEntity findOrThrow(final UUID id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("User by id " + id + " was not found")
                );
    }

    private UserDto convertToDto(UserEntity entity) {
        return modelMapper.map(entity, UserDto.class);
    }

    private UserEntity convertToEntity(UserDto dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

}
