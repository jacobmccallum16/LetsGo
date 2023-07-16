package com.example.letsgov1;

import com.example.letsgov1.entities.User;
import com.example.letsgov1.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class LetsGoV1Application {

    public static void main(String[] args) {
        SpringApplication.run(LetsGoV1Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
//          userRepository.save(
//                  new User(null, "First", "Last",
//                          "firstlast@gmail.com", "password", false,
//                          "fLast", "inactive", 0,
//                          0.0, 0.0, 0.0,
//                          new Timestamp(System.currentTimeMillis()),
//                          new Timestamp(System.currentTimeMillis())
//          ));
        };
    }
}
