package com.example.ecommerceApp.mapper;

import com.example.ecommerceApp.dto.UserDto;
import com.example.ecommerceApp.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-13T09:53:34+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( userDto.getEmail() );
        user.id( userDto.getId() );
        user.isAdmin( userDto.getIsAdmin() );
        user.name( userDto.getName() );
        user.password( userDto.getPassword() );

        return user.build();
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.email( user.getEmail() );
        userDto.id( user.getId() );
        userDto.isAdmin( user.getIsAdmin() );
        userDto.name( user.getName() );
        userDto.password( user.getPassword() );

        return userDto.build();
    }
}
