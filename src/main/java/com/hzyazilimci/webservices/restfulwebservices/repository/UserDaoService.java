package com.hzyazilimci.webservices.restfulwebservices.repository;

import com.hzyazilimci.webservices.restfulwebservices.entities.dtos.create.CreateUserRequest;
import com.hzyazilimci.webservices.restfulwebservices.entities.sourceEntities.User;

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
