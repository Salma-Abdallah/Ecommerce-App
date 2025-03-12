package com.example.ecommerceApp.service;

import com.example.ecommerceApp.dto.UserDto;
import com.example.ecommerceApp.entity.User;
import com.example.ecommerceApp.mapper.UserMapper;
import com.example.ecommerceApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

//    public Optional<User> getById(Integer id){
//        return userRepository.findById(id);
//    }

    public UserDto getById(Integer id){
//        return userRepository.findById(id);
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found with ID: "+id+ userRepository.findById(id)));
        return userMapper.toDto(user);
    }

    public UserDto addUser(UserDto userDto){
        System.out.println("*******Password = "+userDto.getPassword());
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        System.out.println("*******Encoded Password = "+userDto.getPassword());

        User user = userRepository.save(userMapper.toEntity(userDto));

        return userMapper.toDto(user);
    }
    public Optional<UserDto> authenticateUser(String email, String password){
        Optional<User> user = userRepository.findByEmail(email);
//                .orElseThrow(()-> new RuntimeException("User not found with email: "+email+ userRepository.findByEmail(email)));

        if(user.isPresent() &&passwordEncoder.matches(password, user.get().getPassword()))
            return Optional.of(userMapper.toDto(user.get()));
        else
            return Optional.empty();
    }

}
