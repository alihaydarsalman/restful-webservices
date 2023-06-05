package com.hzyazilimci.webservices.restfulwebservices.controller;

import com.hzyazilimci.webservices.restfulwebservices.entities.converter.UserConverter;
import com.hzyazilimci.webservices.restfulwebservices.entities.dtos.create.CreateUserRequest;
import com.hzyazilimci.webservices.restfulwebservices.entities.dtos.get.GetUserDto;
import com.hzyazilimci.webservices.restfulwebservices.entities.sourceEntities.User;
import com.hzyazilimci.webservices.restfulwebservices.repository.UserDaoService;
import jakarta.validation.Valid;
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
    private final UserConverter converter;

    @GetMapping("/getAll")
    public List<GetUserDto> findAll(){
        return this.converter.convertUserToDto(this.userDaoService.findAll());
    }

    @GetMapping("{id}")
    public GetUserDto findById(@PathVariable Integer id){
        return this.converter.convertUserToDto(this.userDaoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody CreateUserRequest request){

        User savedUser = this.userDaoService.save(request);

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
