package com.example.letsgov1;

import com.example.letsgov1.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LetsGoV1Application {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(LetsGoV1Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
//            userRepository.save(new User("admin"));
//            userRepository.save(new User("A", "B"));
//            userRepository.save(new User("C", "D"));
//            userRepository.save(new User("E", "F"));
//            userRepository.save(new User("G", "H"));
//            userRepository.save(new User("I", "J"));
//            userRepository.save(new User("K", "L"));
//            userRepository.save(new User("M", "N"));
//            userRepository.save(new User("O", "P"));
//            userRepository.save(new User("Q", "R"));
//            userRepository.save(new User("S", "T"));
//            userRepository.save(new User("U", "V"));
//            userRepository.save(new User("W", "X"));
//            userRepository.save(new User("Y", "Z"));
        };
    }
}
