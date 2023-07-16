package com.hzyazilimci.webservices.restfulwebservices.post.entities.dtos.create;

import lombok.Builder;
import lombok.Data;

/**
 * @author hzyazilimci
 */
@Builder
@Data
public class CreatePostRequest {

    private String description;
    private Integer userId;
}
