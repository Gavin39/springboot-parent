package com.gavin.springboot.asserts;

import com.gavin.springboot.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * @author Gavin
 * @date 2021/6/15 16:10
 * @since 1.0.0
 */
public final class ServiceAssert {

    private ServiceAssert() {
    }

    /**
     * 对象为空时响应具体异常信息
     * <p>
     * {@link HttpStatus#INTERNAL_SERVER_ERROR}
     *
     * @param obj
     * @param message
     */
    public static void isNull(Object obj, String message) {

        isNull(true, obj, HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    /**
     * 字符串为空时响应具体异常信息
     * <p>
     * {@link HttpStatus#INTERNAL_SERVER_ERROR}
     *
     * @param charSequence
     * @param message
     */
    public static void isBlank(CharSequence charSequence, String message) {

        isBlank(true, charSequence, HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    /**
     * 集合为空时响应具体异常信息
     * <p>
     * {@link HttpStatus#INTERNAL_SERVER_ERROR}
     *
     * @param collection
     * @param message
     */
    public static void isEmpty(Collection<?> collection, String message) {

        isEmpty(true, collection, HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    /**
     * map为空时响应具体异常信息
     * <p>
     * {@link HttpStatus#INTERNAL_SERVER_ERROR}
     *
     * @param map
     * @param message
     */
    public static void isEmpty(Map<?, ?> map, String message) {

        isEmpty(true, map, HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    /**
     * 对象为空时响应具体状态与信息
     * <p>
     * {@link HttpStatus}
     *
     * @param obj
     * @param status
     * @param message
     */
    public static void isNull(Object obj, HttpStatus status, String message) {

        isNull(true, obj, status, message);
    }

    /**
     * 字符串为空时响应具体状态与信息
     * <p>
     * {@link HttpStatus}
     *
     * @param charSequence
     * @param status
     * @param message
     */
    public static void isBlank(CharSequence charSequence, HttpStatus status, String message) {

        isBlank(true, charSequence, status, message);
    }

    /**
     * 集合为空时响应具体状态与信息
     * <p>
     * {@link HttpStatus}
     *
     * @param collection
     * @param status
     * @param message
     */
    public static void isEmpty(Collection<?> collection, HttpStatus status, String message) {

        isEmpty(true, collection, status, message);
    }

    /**
     * map为空时响应具体状态与信息
     * <p>
     *
     * @param map
     * @param status
     * @param message
     */
    public static void isEmpty(Map<?, ?> map, HttpStatus status, String message) {

        isEmpty(true, map, status, message);
    }

    /**
     * 前置条件为true并且对象为空时响应具体状态与信息
     * <p>
     * {@link ServiceException#ServiceException(HttpStatus, String)}
     *
     * @param preCondition
     * @param obj
     * @param status
     * @param message
     */
    public static void isNull(boolean preCondition, Object obj, HttpStatus status, String message) {
        if (preCondition && Objects.isNull(obj)) {

            throw new ServiceException(status, message);
        }
    }

    /**
     * 前置条件为true并且字符串为空时响应具体状态与信息
     * <p>
     * {@link ServiceException#ServiceException(HttpStatus, String)}
     *
     * @param preCondition
     * @param charSequence
     * @param status
     * @param message
     */
    public static void isBlank(boolean preCondition, CharSequence charSequence, HttpStatus status, String message) {
        if (preCondition && StringUtils.isBlank(charSequence)) {

            throw new ServiceException(status, message);
        }
    }

    /**
     * 前置条件为true并且集合为空时响应具体状态与信息
     * <p>
     * {@link ServiceException#ServiceException(HttpStatus, String)}
     *
     * @param preCondition
     * @param collection
     * @param status
     * @param message
     */
    public static void isEmpty(boolean preCondition, Collection<?> collection, HttpStatus status, String message) {
        if (preCondition && CollectionUtils.isEmpty(collection)) {

            throw new ServiceException(status, message);
        }
    }

    /**
     * 前置条件为true并且map为空时响应具体状态与信息
     * <p>
     * {@link ServiceException#ServiceException(HttpStatus, String)}
     *
     * @param preCondition
     * @param map
     * @param status
     * @param message
     */
    public static void isEmpty(boolean preCondition, Map<?, ?> map, HttpStatus status, String message) {
        if (preCondition && CollectionUtils.isEmpty(map)) {

            throw new ServiceException(status, message);
        }
    }
}
