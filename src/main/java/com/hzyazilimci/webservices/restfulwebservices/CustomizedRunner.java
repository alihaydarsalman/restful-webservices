package com.hzyazilimci.webservices.restfulwebservices;

import com.hzyazilimci.webservices.restfulwebservices.post.entities.sourceEntities.Post;
import com.hzyazilimci.webservices.restfulwebservices.post.repository.PostRepository;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.repository.UserRepository;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.sourceEntities.User;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;


/**
 * @author hzyazilimci
 */

@Component
public class CustomizedRunner implements CommandLineRunner {

    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public CustomizedRunner(UserRepository userRepository, PostRepository postRepository){
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

            User user1 = User.builder()
                    .name("Alihaydar")
                    .birthDate(LocalDate.now().minusYears(5).minusMonths(5).minusDays(6))
                    .build();

            User user2 = User.builder()
                    .name("Tony")
                    .birthDate(LocalDate.now().minusYears(1).minusMonths(2).minusDays(3))
                    .build();

            User user3 = User.builder()
                    .name("Isaac")
                    .birthDate(LocalDate.now().minusYears(3).minusWeeks(2))
                    .build();


            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);


            Post post1 = Post.builder()
                    .postId(1)
                    .description("Ilk post.")
                    .user(user1)
                    .build();

            Post post2 = Post.builder()
                    .postId(2)
                    .description("Ikinci post.")
                    .user(user2)
                    .build();

            Post post3 = Post.builder()
                    .postId(3)
                    .description("Ucuncu post.")
                    .user(user2)
                    .build();

            Post post4 = Post.builder()
                    .postId(4)
                    .description("Dorduncu post.")
                    .user(user1)
                    .build();
            /*
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);
            postRepository.save(post4);*/
    }
}
