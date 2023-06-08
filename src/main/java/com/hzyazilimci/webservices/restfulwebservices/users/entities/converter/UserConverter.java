package com.hzyazilimci.webservices.restfulwebservices.users.entities.converter;

import com.hzyazilimci.webservices.restfulwebservices.users.entities.sourceEntities.User;
import com.hzyazilimci.webservices.restfulwebservices.users.entities.dtos.get.GetUserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hzyazilimci
 */

@Component
public class UserConverter {

    public GetUserDto convertUserToDto(User user){
        return GetUserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .birthDate(user.getBirthDate())
                .build();
    }

    public List<GetUserDto> convertUserToDto(List<User> users){
        return users.stream().map(this::convertUserToDto).collect(Collectors.toList());
    }
}
