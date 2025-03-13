package com.example.ecommerceApp.controller;

import com.example.ecommerceApp.dto.LoginRequest;
import com.example.ecommerceApp.dto.UserDto;
import com.example.ecommerceApp.entity.User;
import com.example.ecommerceApp.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Tag(name = "User Management", description = "Endpoints for managing users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        // return userService.getAllUsers();
        List<UserDto> userDtos = userService.getAllUsers();

        if(userDtos.isEmpty()){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Success", false);
            errorResponse.put("Message", "No Users found");
    
            return ResponseEntity.status(404).body(errorResponse);
        }
        else {
            Map<String, Object> response = new HashMap<>();
            response.put("Success", true);
            response.put("Data", userDtos); 
            response.put("Message", "get all users successful");

            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        UserDto user = userService.getById(id);
        if(user.equals(null)){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Success", false);
            errorResponse.put("Message", "Can't get user with id "+id);
    
            return ResponseEntity.status(404).body(errorResponse);
        }
        else{
            Map<String, Object> response = new HashMap<>();
            response.put("Success", true);
            response.put("Data", user); 
            response.put("Message", "get user"+ id +"successful");

            return ResponseEntity.ok(response);
        }
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        UserDto user = userService.addUser(userDto);

        if(user.equals(null)){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Success", false);
            errorResponse.put("Message", "Can't add user");
    
            return ResponseEntity.status(404).body(errorResponse);
        }
        else{
            Map<String, Object> response = new HashMap<>();
            response.put("Success", true);
            response.put("Data", user); 
            response.put("Message", "add new user successful");

            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Received Email: " + loginRequest.getEmail()); // Debugging
        System.out.println("Received Password: " + loginRequest.getPassword());

        Optional<UserDto> userDto = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (userDto.isPresent()) {
            System.out.println(userDto.get());
            Map<String, Object> response = new HashMap<>();
            response.put("Success", true);
            response.put("Data", userDto.get()); 
            response.put("Message", "Login successful");

            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Success", false);
            errorResponse.put("Message", "Invalid email or password 🚫");
    
            return ResponseEntity.status(401).body(errorResponse);
        }
    }

}
