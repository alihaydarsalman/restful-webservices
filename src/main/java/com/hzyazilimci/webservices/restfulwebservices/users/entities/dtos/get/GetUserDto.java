package com.hzyazilimci.webservices.restfulwebservices.users.entities.dtos.get;

import lombok.*;

import java.time.LocalDate;

/**
 * @author hzyazilimci
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class GetUserDto {

    private Integer id;
    private String name;
    private LocalDate birthDate;
}
