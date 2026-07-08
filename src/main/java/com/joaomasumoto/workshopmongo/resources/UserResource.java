package com.joaomasumoto.workshopmongo.resources;


import com.joaomasumoto.workshopmongo.domain.User;
import com.joaomasumoto.workshopmongo.dto.UserDTO;
import com.joaomasumoto.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();

        // Starts a stream from the list of users
        List<UserDTO> listDTO = list.stream()
                // Maps each User to a UserDTO
                .map(UserDTO::new )
                // Converts the stream back into a List
                .toList();

        return ResponseEntity.ok().body(listDTO);
    }
}

