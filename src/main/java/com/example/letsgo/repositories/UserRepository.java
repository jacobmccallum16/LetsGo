package com.example.letsgo.repositories;

import com.example.letsgo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findUsersByUserId(Integer keyId);
    User findUserByUserId(Integer keyId);
}