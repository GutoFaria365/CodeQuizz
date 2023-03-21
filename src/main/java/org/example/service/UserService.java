package org.example.service;

import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.dto.UserUpdateDto;

import java.util.List;

public interface UserService {

    //UserDto createUser(UserCreatedDto userCreatedDto);

    UserDto getUserById(Long userId);

    UserDto getUserByEmail(String userEmail);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserUpdateDto userUpdateDto);

}
