package com.hzyazilimci.webservices.restfulwebservices.post.repository;

import com.hzyazilimci.webservices.restfulwebservices.post.entities.sourceEntities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hzyazilimci
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostByUserIdAndPostId(Integer postId, Integer userId);
}
