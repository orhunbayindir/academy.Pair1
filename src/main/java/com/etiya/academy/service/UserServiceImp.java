package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.dto.user.CreateUserDto;
import com.etiya.academy.dto.user.UserDto;
import com.etiya.academy.entity.User;
import com.etiya.academy.mapper.UserMapper;
import com.etiya.academy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::dtoFromUser).toList();
    }

    @Override
    public User add(CreateUserDto dto) {
        if(userRepository.findByIdentityNo(dto.getIdentityNo()).isPresent()){
            throw new BusinessException("Bu kimlik no'ya sahip kişinin zaten bir hesabı var.");
        }

        return userRepository.save(UserMapper.INSTANCE.userFromCreateDto(dto));
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if( user.isPresent() )
            return UserMapper.INSTANCE.dtoFromUser(user.get());
        return null;
    }

    @Override
    public UserDto update(Integer id, CreateUserDto dto) {
        Optional<User> user = userRepository.findById(id);
        if( user.isEmpty() ){
            throw new BusinessException("Bu id'ye sahip User yok.");
        }
        if(userRepository.findByIdentityNo(dto.getIdentityNo()).isPresent()){
            throw new BusinessException("Bu kimlik no'ya sahip kişinin zaten bir hesabı var.");
        }

        User userToBeSaved = UserMapper.INSTANCE.userFromCreateDto(dto);
        userToBeSaved.setId(user.get().getId());
        return UserMapper.INSTANCE.dtoFromUser(userRepository.save(userToBeSaved));
    }
}
