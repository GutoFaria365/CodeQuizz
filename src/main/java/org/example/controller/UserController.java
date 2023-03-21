package org.example.controller;

import academy.mindswap.rentacar.config.JwtAuthenticationFilter;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.dto.UserUpdateDto;
import academy.mindswap.rentacar.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<UserDto> getOwnInfo() {
        UserDto userDto = userService.getUserByEmail(JwtAuthenticationFilter.getUserEmail());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDto userUpdateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserDto updatedUser = userService.updateUser(id, userUpdateDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
