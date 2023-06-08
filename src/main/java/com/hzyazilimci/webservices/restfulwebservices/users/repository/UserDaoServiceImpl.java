package com.hzyazilimci.webservices.restfulwebservices.users.repository;

import com.hzyazilimci.webservices.restfulwebservices.users.entities.converter.UserConverter;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.sourceEntities.User;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.dtos.create.CreateUserRequest;
import com.hzyazilimci.webservices.restfulwebservices.utils.exceptions.UserNotFoundException;
import com.hzyazilimci.webservices.restfulwebservices.utils.messages.ExceptionMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author hzyazilimci
 */

@RequiredArgsConstructor
@Component
public class UserDaoServiceImpl implements UserDaoService {

    private final UserConverter converter;

    private static List<User> users = new ArrayList<>();

    private static int userId = 0;

    static {
        users.add(new User(++userId,"Alihaydar", LocalDate.now().minusYears(24)));
        users.add(new User(++userId,"Antonio", LocalDate.now().minusYears(46)));
        users.add(new User(++userId,"Jack", LocalDate.now().minusYears(13)));
        users.add(new User(++userId,"Adam", LocalDate.now().minusYears(5)));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Integer id){

        existsById(id);

        Predicate< ? super User > predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    @Override
    public User save(CreateUserRequest request) {
        User buildedUser = User.builder()
                .id(++userId)
                .name(request.getName().trim())
                .birthDate(request.getBirthDate())
                .build();

        users.add(buildedUser);

        return buildedUser;
    }

    @Override
    public void delete(Integer id){

        User user = findById(id);

        users.remove(user);
    }

    private void existsById(Integer id){
        boolean existsFlag = false;

        for (User user: users){
            if (user.getId().equals(id)){
                existsFlag = true;
            }
        }

        if (!existsFlag){
            throw new UserNotFoundException(ExceptionMessages.UserExceptionMessages.USER_NOT_FOUND_EXCEPTION);
        }
    }
}

