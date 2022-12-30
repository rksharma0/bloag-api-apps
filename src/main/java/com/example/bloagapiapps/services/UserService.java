package com.example.bloagapiapps.services;

import com.example.bloagapiapps.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto>getAllUsers();
    void deleteUser(Integer userId);
}
