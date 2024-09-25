package com.etiya.academy.repository;

import com.etiya.academy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    void deleteById(Integer id);
    Optional<User> findByIdentityNo(String identityNo);
}
