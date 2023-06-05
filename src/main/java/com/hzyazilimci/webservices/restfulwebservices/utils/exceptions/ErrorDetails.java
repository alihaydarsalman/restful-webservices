package com.hzyazilimci.webservices.restfulwebservices.utils.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hzyazilimci
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails<T> {

    private LocalDateTime timestamp;
    private T message;
    private String details;
}
