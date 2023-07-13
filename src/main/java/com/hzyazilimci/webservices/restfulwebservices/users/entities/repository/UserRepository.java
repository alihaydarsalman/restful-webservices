package com.hzyazilimci.webservices.restfulwebservices.users.entities.repository;

import com.hzyazilimci.webservices.restfulwebservices.users.entities.sourceEntities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hzyazilimci
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int id);
}
