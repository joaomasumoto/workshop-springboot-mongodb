package com.joaomasumoto.workshopmongo.resources;


import com.joaomasumoto.workshopmongo.domain.Post;
import com.joaomasumoto.workshopmongo.domain.User;
import com.joaomasumoto.workshopmongo.dto.PostDTO;
import com.joaomasumoto.workshopmongo.dto.UserDTO;
import com.joaomasumoto.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = service.fromDTO(objDto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value="/{id}/posts")
    public ResponseEntity<List<PostDTO>> findPosts(@PathVariable String id) {
        List<Post> posts = service.findById(id).getPosts();
        List<PostDTO> postsDTO = posts.stream().map(PostDTO::new).toList();
        return ResponseEntity.ok().body(postsDTO);
    }


}

