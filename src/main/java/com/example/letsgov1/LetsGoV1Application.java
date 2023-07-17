package com.example.letsgov1;

import com.example.letsgov1.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LetsGoV1Application {

    public static void main(String[] args) {
        SpringApplication.run(LetsGoV1Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
//            userRepository.save( new User(null, "F", "L", "fl@gmail.com", "fl", false, "fl", "active", 0, 0f, 0f, 0f, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
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
