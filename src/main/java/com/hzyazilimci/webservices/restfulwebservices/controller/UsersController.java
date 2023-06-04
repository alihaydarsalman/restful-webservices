package com.hzyazilimci.webservices.restfulwebservices.controller;

import com.hzyazilimci.webservices.restfulwebservices.entities.sourceEntities.User;
import com.hzyazilimci.webservices.restfulwebservices.repository.UserDaoService;
import com.hzyazilimci.webservices.restfulwebservices.utils.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author hzyazilimci
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

    private final UserDaoService userDaoService;

    @GetMapping("/getAll")
    public List<User> findAll(){
        return this.userDaoService.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Integer id){
        return this.userDaoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User savedUser = this.userDaoService.save(user);

        URI location = ServletUriComponentsBuilder
                          .fromCurrentRequest() //bu metotta kullanilan path
                          .path("/{id}") //pathin arkasina eklenecek variable /api/users/3 gibi
                          .buildAndExpand(savedUser.getId()) //{id} parametresi yerine ne verilecekse onunn belirtilmesi
                          .toUri(); //bu pathin bir uri' ye donusturulmesi

        return ResponseEntity.created(location).build(); //http header' da location' in gonderilmesi.
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        this.userDaoService.delete(id);
    }
}
