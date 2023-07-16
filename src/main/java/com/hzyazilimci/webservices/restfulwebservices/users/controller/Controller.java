package com.hzyazilimci.webservices.restfulwebservices.users.controller;

import com.hzyazilimci.webservices.restfulwebservices.post.entities.converter.PostConverter;
import com.hzyazilimci.webservices.restfulwebservices.post.entities.dtos.create.CreatePostRequest;
import com.hzyazilimci.webservices.restfulwebservices.post.entities.dtos.get.GetPostDto;
import com.hzyazilimci.webservices.restfulwebservices.post.entities.sourceEntities.Post;
import com.hzyazilimci.webservices.restfulwebservices.post.repository.PostRepository;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.repository.UserRepository;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author hzyazilimci
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {

    //private final UserDaoService userDaoService;
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PostRepository postRepository;
    private final PostConverter postConverter;

    @GetMapping("/users/getAll")
    public List<GetUserDto> findAll(){
        return this.userConverter.convertUserToDto(this.userRepository.findAll());
    }

    @GetMapping("/users/{id}")
    public EntityModel<GetUserDto> findById(@PathVariable Integer id) throws UserNotFoundException{

        Optional<User> userModel = this.userRepository.findById(id);
        if (userModel.isEmpty()){
            throw new UserNotFoundException("Getirilmek istenen kullanici bulunamadi. ID: "+id);
        }
        GetUserDto userResponse = userConverter.convertUserToDto(userModel.get());

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

    @PostMapping("/users/save")
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

    @DeleteMapping("/users/delete/{id}")
    public void delete(@PathVariable Integer id) throws UserNotFoundException {

        if (userRepository.existsById(id)){
            this.userRepository.deleteById(id);
        }else
            throw new UserNotFoundException("Silinmek istenen kullanici bulunamadi.");
    }

    @GetMapping("/users/{id}/posts")
    public List<GetPostDto> getPostsForUser(@PathVariable Integer id) throws UserNotFoundException {

        Optional<User> userModel = this.userRepository.findById(id);
        if (userModel.isEmpty()){
            throw new UserNotFoundException("Getirilmek istenen kullanici bulunamadi. ID: "+id);
        }

        List<Post> posts = userModel.get().getPostList();
        List<GetPostDto> responsePostDto = new ArrayList<>();

        for (Post post: posts){
            GetPostDto getPostDto = postConverter.convertPostToDto(post);
            responsePostDto.add(getPostDto);
        }

        return responsePostDto;
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> save(@RequestBody CreatePostRequest createPostRequest){

        Optional<User> user = userRepository.findById(createPostRequest.getUserId());
        if (user.isEmpty()){
            throw new UserNotFoundException("Kullanici bulunamadi.");
        }

        Post post = Post.builder()
                .description(createPostRequest.getDescription())
                .user(user.get())
                .build();

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(savedPost.getPostId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}/posts/{postId}")
    public GetPostDto getPostForUser(@PathVariable Integer id, @PathVariable Integer postId){

        Optional<User> user = this.userRepository.findById(id);

        List<Post> posts = user.get().getPostList();

        Post postToReturn = new Post();

        for (Post post: posts){
            if (post.getPostId().equals(postId)){
                postToReturn = post;
            }
        }

        return postConverter.convertPostToDto(postToReturn);
    }
}
