package com.hzyazilimci.webservices.restfulwebservices.post.entities.sourceEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.sourceEntities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzyazilimci
 */

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + postId + ", " +
                "description = " + description + ")";
    }
}
