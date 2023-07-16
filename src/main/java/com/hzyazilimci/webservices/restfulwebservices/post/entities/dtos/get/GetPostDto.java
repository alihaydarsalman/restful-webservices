package com.hzyazilimci.webservices.restfulwebservices.post.entities.dtos.get;

import lombok.Builder;
import lombok.Data;

/**
 * @author hzyazilimci
 */
@Builder
@Data
public class GetPostDto {

    private Integer postId;
    private String description;
    private String userName;
}
