package com.hzyazilimci.webservices.restfulwebservices;

import com.hzyazilimci.webservices.restfulwebservices.users.entities.repository.UserRepository;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.sourceEntities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author hzyazilimci
 */

@Component
public class CustomizedRunner implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public CustomizedRunner(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private User user1 = User.builder()
            .id(101)
            .name("Alihaydar")
            .birthDate(LocalDate.now().minusYears(5).minusMonths(5).minusDays(6))
            .build();

    private User user2 = User.builder()
            .id(102)
            .name("Tony")
            .birthDate(LocalDate.now().minusYears(1).minusMonths(2).minusDays(3))
            .build();

    private User user3 = User.builder()
            .id(103)
            .name("Isaac")
            .birthDate(LocalDate.now().minusYears(3).minusWeeks(2))
            .build();

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
