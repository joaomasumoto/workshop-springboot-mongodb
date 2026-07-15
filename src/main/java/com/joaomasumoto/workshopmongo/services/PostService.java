package com.joaomasumoto.workshopmongo.services;

import com.joaomasumoto.workshopmongo.domain.Post;
import com.joaomasumoto.workshopmongo.repository.PostRepository;
import com.joaomasumoto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Date;
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
        return repo.findByTitleContaining(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        Date maxExclusive = Date.from(maxDate.toInstant().plus(1, ChronoUnit.DAYS));
        return repo.fullSearch(text, minDate, maxExclusive);
    }


}
