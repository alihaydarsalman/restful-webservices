package com.hzyazilimci.webservices.restfulwebservices.utils.messages;

/**
 * @author hzyazilimci
 */
public class ExceptionMessages {

    public static class GeneralExceptionMessages{
        public static final String CANNOT_NULL_OR_EMPTY = "This field must not be null or empty.";
        public static final String CANNOT_BLANK = "This field must not be blank.";
        public static final String ID_CANNOT_LESS_THAN_ONE = "ID is cannot be equal or less than zero.";
    }

    public static class UserExceptionMessages{
        public static final String USER_NOT_FOUND_EXCEPTION = "User not found.";
        public static final String USER_NAME_VALIDATION_EXCEPTION = "User name size has to be 2-60 characters. And name cannot contains special characters.";
        public static final String USER_BIRTHDAY_VALIDATION_EXCEPTION = "Birthday cannot after today.";
    }
}
