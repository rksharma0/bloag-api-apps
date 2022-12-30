package com.example.bloagapiapps.controllers;

import com.example.bloagapiapps.payloads.UserDto;
import com.example.bloagapiapps.services.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<?>createUser(@RequestBody UserDto userDto){

        UserDto createUserDto=this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<?>updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer id){

        UserDto updatedUser=this.userService.updateUser(userDto,id);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer id){

        this.userService.deleteUser(id);

        return new ResponseEntity(Map.of("message","user deleted successfully"),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>>getAllUsers(){

        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?>getUserById(@PathVariable("userId") Integer id){

        return ResponseEntity.ok(this.userService.getUserById(id));
    }

}
