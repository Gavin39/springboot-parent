package com.gavin.springboot.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Gavin
 * @date 2021/6/15 15:26
 * @since 1.0.0
 */
public final class StrategyException extends GenericException {

    public StrategyException(int code, String message) {
        super(code, message);
    }

    public StrategyException(HttpStatus status, String message) {
        super(status, message);
    }

    public StrategyException(String message) {
        super(message);
    }
}
