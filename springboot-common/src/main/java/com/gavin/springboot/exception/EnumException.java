package com.gavin.springboot.exception;

import org.springframework.http.HttpStatus;

/**
 * 枚举异常
 *
 * @author Gavin
 * @date 2021/1/8 15:53
 * @since 1.0.0
 */
public class EnumException extends GenericException {

    public EnumException(int code, String message) {
        super(code, message);
    }

    public EnumException(HttpStatus status, String message) {
        super(status, message);
    }

    public EnumException(String message) {
        super(message);
    }
}
