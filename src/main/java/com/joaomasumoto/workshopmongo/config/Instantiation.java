package com.joaomasumoto.workshopmongo.config;

import com.joaomasumoto.workshopmongo.domain.Post;
import com.joaomasumoto.workshopmongo.domain.User;
import com.joaomasumoto.workshopmongo.dto.AuthorDTO;
import com.joaomasumoto.workshopmongo.repository.PostRepository;
import com.joaomasumoto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User jiraya = new User(null, "Jiraya Sensei", "jiraya@gmail.com");
        User tsunade = new User(null, "Tsunade Sama", "tsuna@gmail.com");
        User orochimaru = new User(null, "Orochimaru Sannin", "orochi@gmail.com");

        userRepository.saveAll(Arrays.asList(jiraya, tsunade, orochimaru));

        Post post1 = new Post(null, sdf.parse("22/03/2025"), "Mission number 2314", "Sunagakure mission completed. Returning to Konoha.", new AuthorDTO(jiraya));
        Post post2 = new Post(null, sdf.parse("03/07/2026"), "Mission number 5588", "Infiltration phase successfull. Proceeding to stage two.", new AuthorDTO(orochimaru));

        postRepository.saveAll(Arrays.asList(post1, post2));

        jiraya.getPosts().add(post1);
        userRepository.save(jiraya);

        orochimaru.getPosts().add(post2);
        userRepository.save(orochimaru);

    }
}
