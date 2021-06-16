package com.gavin.springboot.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Gavin
 * @date 2021/6/15 15:12
 * @since 1.0.0
 */
public final class ServiceException extends GenericException {

	public ServiceException(int code, String message) {
        super(code, message);
    }

    public ServiceException(HttpStatus status, String message) {
        super(status, message);
    }

    public ServiceException(String message) {
        super(message);
    }
}
