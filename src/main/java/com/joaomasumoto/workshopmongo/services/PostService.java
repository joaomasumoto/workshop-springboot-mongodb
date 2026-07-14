package com.joaomasumoto.workshopmongo.services;

import com.joaomasumoto.workshopmongo.domain.Post;
import com.joaomasumoto.workshopmongo.repository.PostRepository;
import com.joaomasumoto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post not found."));
    }

    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }

}
