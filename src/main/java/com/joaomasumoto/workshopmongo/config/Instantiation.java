package com.joaomasumoto.workshopmongo.config;

import com.joaomasumoto.workshopmongo.domain.User;
import com.joaomasumoto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User jiraya = new User(null, "Jiraya Sensei", "jiraya@gmail.com");
        User tsunade = new User(null, "Tsunade Sama", "tsuna@gmail.com");
        User orochimaru = new User(null, "Orochimaru Sannin", "orochi@gmail.com");

        userRepository.saveAll(Arrays.asList(jiraya, tsunade, orochimaru));
    }
}
