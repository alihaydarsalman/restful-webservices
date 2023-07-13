package com.hzyazilimci.webservices.restfulwebservices.users.controller;

import com.hzyazilimci.webservices.restfulwebservices.users.entities.repository.UserRepository;
import com.hzyazilimci.webservices.restfulwebservices.users.repository.UserDaoService;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.converter.UserConverter;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.dtos.create.CreateUserRequest;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.sourceEntities.User;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.dtos.get.GetUserDto;
import com.hzyazilimci.webservices.restfulwebservices.utils.exceptions.UserNotFoundException;
import com.hzyazilimci.webservices.restfulwebservices.utils.hateoas.CustomEntityModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * @author hzyazilimci
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

    //private final UserDaoService userDaoService;
    private final UserRepository userRepository;
    private final UserConverter converter;

    @GetMapping("/getAll")
    public List<GetUserDto> findAll(){
        return this.converter.convertUserToDto(this.userRepository.findAll());
    }

    @GetMapping("{id}")
    public EntityModel<GetUserDto> findById(@PathVariable Integer id){

        Optional<User> userModel = this.userRepository.findById(id);
        GetUserDto userResponse = converter.convertUserToDto(userModel.get());

        EntityModel<GetUserDto> entityModel = new CustomEntityModel<>(userResponse);

        WebMvcLinkBuilder linkToFindAll = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
        WebMvcLinkBuilder linkToFindById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findById(id));

        entityModel.add(linkToFindAll.withRel("getAllUsers"));
        entityModel.add(linkToFindById.withRel("findById"));

        return entityModel;

        /**
         * CustomEntityModel sinifini yazmadan Hateos kutuphanesindeki EntityModel' i kullanarak da asagidaki sekilde calistirilabilir:
         *
         *         EntityModel<GetUserDto> entityModel = EntityModel.of(this.converter.convertUserToDto(this.userDaoService.findById(id)));
         *
         *         WebMvcLinkBuilder linkToFindAll = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
         *         WebMvcLinkBuilder linkToFindById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findById(id));
         *
         *         entityModel.add(linkToFindAll.withRel("retrieve_all_users"));
         *         entityModel.add(linkToFindById.withRel("findById"));
         *
         *         return entityModel;
         *
         * */
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@Valid @RequestBody CreateUserRequest request){

        User user = User.builder()
                .name(request.getName())
                .birthDate(request.getBirthDate())
                .build();

        User savedUser = this.userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                          .fromCurrentRequest() //bu metotta kullanilan path
                          .path("/{id}") //pathin arkasina eklenecek variable /api/users/3 gibi
                          .buildAndExpand(savedUser.getId()) //{id} parametresi yerine ne verilecekse onunn belirtilmesi
                          .toUri(); //bu pathin bir uri' ye donusturulmesi

        return ResponseEntity.created(location).build(); //http header' da location' in gonderilmesi.
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws UserNotFoundException {

        if (userRepository.existsById(id)){
            this.userRepository.deleteById(id);
        }else
            throw new UserNotFoundException("Silinmek istenen kullanici bulunamadi.");
    }
}
