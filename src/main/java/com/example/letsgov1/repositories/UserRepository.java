package com.example.letsgov1.repositories;

import com.example.letsgov1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
