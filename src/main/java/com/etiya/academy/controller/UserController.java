package com.etiya.academy.controller;

import com.etiya.academy.dto.user.CreateUserDto;
import com.etiya.academy.dto.user.UserDto;
import com.etiya.academy.entity.User;
import com.etiya.academy.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody @Valid CreateUserDto userDto)
    {
        User user = userService.add(userDto);
        if (user != null)
            return ResponseEntity.status(201).build();
        return ResponseEntity.status(404).build();
    }

    @GetMapping("id")
    public ResponseEntity<UserDto> getById(@RequestParam Integer id){
        UserDto user = userService.getById(id);
        if (user != null)
            return ResponseEntity.ok(user);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Integer id, @RequestBody @Valid CreateUserDto dto){
        UserDto user = userService.update(id, dto);
        return ResponseEntity.status(200).body(user);
    }

}
