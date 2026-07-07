package com.joaomasumoto.workshopmongo.resources;


import com.joaomasumoto.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User naruto = new User("1", "Naruto Uzumaki", "naruto@gmail.com");
        User sasuke = new User("2", "Sasuke Uchiha", "sasuke@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(naruto, sasuke));
        return ResponseEntity.ok().body(list);
    }
}
