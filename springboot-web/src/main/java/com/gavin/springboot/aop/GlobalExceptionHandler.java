package com.gavin.springboot.aop;

import com.gavin.springboot.entity.ResponseEntity;
import com.gavin.springboot.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;


/**
 * @author Gavin
 * @date 2021/1/18 17:46
 * @since 1.0.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * ServiceException异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity handleBaseException(ServiceException e, ServletWebRequest request){
        printStackTrace(e, request);
       return ResponseEntity.error(e.getCode(), e.getMessage());
    }

    /**
     * 拦截其他异常并响应
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity otherExceptionHandler(Exception e, ServletWebRequest request) {
        ResponseEntity responseEntity = ResponseEntity.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        printStackTrace(e, request);
        return responseEntity;
    }

    private void printStackTrace(Exception e, ServletWebRequest request) {
        log.error("handler Exception:{} | request:{}", e.getMessage(), request.toString());
        e.printStackTrace();
    }

}
