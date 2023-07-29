package com.example.letsgo;

import com.example.letsgo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
public class LetsGoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LetsGoApplication.class, args);
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

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.indentOutput(true); // Enable indentation and spacing
        return builder;
    }
}
