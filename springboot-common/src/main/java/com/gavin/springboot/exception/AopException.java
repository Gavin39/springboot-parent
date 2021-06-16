package com.gavin.springboot.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Gavin
 * @date 2021/6/15 15:25
 * @since 1.0.0
 */
public final class AopException extends GenericException {

    public AopException(int code, String message) {
        super(code, message);
    }

    public AopException(HttpStatus status, String message) {
        super(status, message);
    }

    public AopException(String message) {
        super(message);
    }
}
