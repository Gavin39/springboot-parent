package com.gavin.springboot.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Gavin
 * @date 2021/6/15 15:09
 * @since 1.0.0
 */
public final class HelperException extends GenericException {

    public HelperException(int code, String message) {
        super(code, message);
    }

    public HelperException(HttpStatus status, String message) {
        super(status, message);
    }

    public HelperException(String message) {
        super(message);
    }
}
