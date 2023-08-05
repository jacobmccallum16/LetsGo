package com.example.letsgo.repositories;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findUsersByUserId(Integer keyId);
    User findUserByUserId(Integer keyId);
    List<User> findUsersByUsernameAndPassword(String username, String password);
    List<User> findUsersByEmailAndPassword(String email, String password);
    User findByUsernameAndPassword(String username, String password);
    User findByEmailAndPassword(String email, String password);
    User findByDriver(Driver driver);
    User findByDriverDriverId(Integer driverId);
}