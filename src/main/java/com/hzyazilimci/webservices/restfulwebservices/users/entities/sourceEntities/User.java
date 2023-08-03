package com.hzyazilimci.webservices.restfulwebservices.users.entities.sourceEntities;

import com.hzyazilimci.webservices.restfulwebservices.post.entities.sourceEntities.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hzyazilimci
 */

@Data
@Entity(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    private List<Post> postList;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "birthDate = " + birthDate + ")";
    }
}
