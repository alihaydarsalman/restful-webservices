package com.hzyazilimci.webservices.restfulwebservices.users.repository;

import com.hzyazilimci.webservices.restfulwebservices.users.entities.dtos.create.CreateUserRequest;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.sourceEntities.User;

import java.util.List;

/**
 * @author hzyazilimci
 */
public interface UserDaoService {

    List<User> findAll();
    User findById(Integer id);
    User save(CreateUserRequest request);
    void delete(Integer id);
}
