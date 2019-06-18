package com.databaseProject.databaseProject.Mapper;

import com.databaseProject.databaseProject.Dto.UserDto;
import com.databaseProject.databaseProject.Model.User;

public class UserMapper {

    public static UserDto fromEntityToDto(User user) {
        return new UserDto(user.getEmail(), user.getFirstName(),
                user.getLastName(), user.getPassword(), user.getIsAdmin(),user.getIsLogged());
    }

    public static User fromDtoToEntity(UserDto userDto) {
        return new User(userDto.getEmail(), userDto.getFirstName(),
                userDto.getLastName(), userDto.getPassword(), userDto.getIsAdmin(), userDto.getIsLogged());
    }
}
