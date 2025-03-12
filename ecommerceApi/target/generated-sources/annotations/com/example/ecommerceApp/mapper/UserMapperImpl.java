package com.example.ecommerceApp.mapper;

import com.example.ecommerceApp.dto.UserDto;
import com.example.ecommerceApp.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-12T10:55:12+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDto.getId() );
        user.name( userDto.getName() );
        user.password( userDto.getPassword() );
        user.email( userDto.getEmail() );
        user.isAdmin( userDto.getIsAdmin() );

        return user.build();
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.name( user.getName() );
        userDto.password( user.getPassword() );
        userDto.email( user.getEmail() );
        userDto.isAdmin( user.getIsAdmin() );

        return userDto.build();
    }
}
