package com.hzyazilimci.webservices.restfulwebservices.users.entities.sourceEntities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * @author hzyazilimci
 */

@Data
@Entity(name = "users")
@Builder
@ToString
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
}
