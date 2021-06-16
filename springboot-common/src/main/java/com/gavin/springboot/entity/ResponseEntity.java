package com.gavin.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Gavin
 * @date 2021/6/15 15:16
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = 6342586971178462022L;
    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 500;
    private static final String SUCCESS_MESSAGE = "操作成功";
    private static final String ERROR_MESSAGE = "操作失败";

    /**
     * 状态码
     */
    private int code;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;


    public static <T> ResponseEntity success(T data) {
        return new ResponseEntity(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> ResponseEntity error(int code, String message) {
        return new ResponseEntity(code, message, null);
    }
    
}
