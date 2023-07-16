package com.hzyazilimci.webservices.restfulwebservices.post.entities.converter;

import com.hzyazilimci.webservices.restfulwebservices.post.entities.dtos.get.GetPostDto;
import com.hzyazilimci.webservices.restfulwebservices.post.entities.sourceEntities.Post;
import org.springframework.stereotype.Component;

/**
 * @author hzyazilimci
 */
@Component
public class PostConverter {

    public GetPostDto convertPostToDto(Post post){
        return GetPostDto.builder()
                .userName(post.getUser().getName())
                .postId(post.getPostId())
                .description(post.getDescription())
                .build();
    }
}
