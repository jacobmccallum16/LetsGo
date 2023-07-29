package com.example.letsgo.repositories;

import com.example.letsgo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findUsersByUserId(Integer keyId);
    User findUserByUserId(Integer keyId);
}