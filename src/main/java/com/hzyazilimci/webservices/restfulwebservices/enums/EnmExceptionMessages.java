package com.hzyazilimci.webservices.restfulwebservices.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hzyazilimci
 */
@Getter
@AllArgsConstructor
public enum EnmExceptionMessages {

    USER_NOT_FOUND("User not found with id = %s");

    private String message;
}
