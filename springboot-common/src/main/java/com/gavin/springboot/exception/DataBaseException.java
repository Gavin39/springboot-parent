package com.gavin.springboot.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Gavin
 * @date 2021/6/15 15:25
 * @since 1.0.0
 */
public final class DataBaseException extends GenericException {

    public DataBaseException(int code, String message) {
        super(code, message);
    }

    public DataBaseException(HttpStatus status, String message) {
        super(status, message);
    }

    public DataBaseException(String message) {
        super(message);
    }
}
