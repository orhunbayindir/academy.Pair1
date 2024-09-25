package com.etiya.academy.mapper;

import com.etiya.academy.dto.user.CreateUserDto;
import com.etiya.academy.dto.user.UserDto;
import com.etiya.academy.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userFromCreateDto(CreateUserDto dto);
    UserDto dtoFromUser(User user);
    User userFromDto(UserDto userDto);

}
