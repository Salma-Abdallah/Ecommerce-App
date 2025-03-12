package com.example.ecommerceApp.controller;


import com.example.ecommerceApp.dto.LoginRequest;
import com.example.ecommerceApp.dto.UserDto;
import com.example.ecommerceApp.entity.User;
import com.example.ecommerceApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
//    public List<User> getAllUsers(){
//        return  userService.getAllUsers();
//    }
    public List<UserDto> getAllUsers(){
        return  userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest){
        Optional<UserDto> userDto = userService.authenticateUser(loginRequest.getEmail(),loginRequest.getPassword());

//        return ResponseEntity.status(200).body("You are Authorithed 👍");
//        return userDto.map(ResponseEntity::ok)
//                .orElseGet(()-> ResponseEntity.status(401).body("Invalid email or password"));
        if(userDto.isPresent())
            return ResponseEntity.status(200).body("You are Authorithed 👍");
        else
            return ResponseEntity.status(401).body("Invalid email or password 🚫");
    }
}
