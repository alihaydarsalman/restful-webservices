package com.hzyazilimci.webservices.restfulwebservices.users.entities.dtos.create;

import com.hzyazilimci.webservices.restfulwebservices.utils.messages.ExceptionMessages;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author hzyazilimci
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    @Pattern(regexp = "^[abcçdefgğhıijklmnoöprsştuüvwqyzABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVWQYZ ]{2,50}",
            message = ExceptionMessages.UserExceptionMessages.USER_NAME_VALIDATION_EXCEPTION)
    @NotEmpty(message = ExceptionMessages.GeneralExceptionMessages.CANNOT_NULL_OR_EMPTY)
    @NotBlank(message = ExceptionMessages.GeneralExceptionMessages.CANNOT_BLANK)
    private String name;

    @NotNull(message = ExceptionMessages.GeneralExceptionMessages.CANNOT_NULL_OR_EMPTY)
    @Past(message = ExceptionMessages.UserExceptionMessages.USER_BIRTHDAY_VALIDATION_EXCEPTION)
    private LocalDate birthDate;
}
