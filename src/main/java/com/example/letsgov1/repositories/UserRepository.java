package com.example.letsgov1.repositories;

import com.example.letsgov1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findUserByUserId (Integer keyId);
}