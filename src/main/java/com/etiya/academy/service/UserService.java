package com.etiya.academy.service;

import com.etiya.academy.dto.user.CreateUserDto;
import com.etiya.academy.dto.user.UserDto;
import com.etiya.academy.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    User add(CreateUserDto dto);

    void delete(Integer id);

    UserDto getById(Integer id);

    UserDto update(Integer id, CreateUserDto dto);
}
