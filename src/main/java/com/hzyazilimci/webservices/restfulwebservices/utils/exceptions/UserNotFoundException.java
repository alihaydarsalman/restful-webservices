package com.hzyazilimci.webservices.restfulwebservices.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author hzyazilimci
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class   UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
