package com.gavin.springboot.helper;

import com.gavin.springboot.exception.*;
import org.springframework.http.HttpStatus;

/**
 * @author Gavin
 * @date 2021/6/15 15:24
 * @since 1.0.0
 */
public final class ExceptionHelper {
    private ExceptionHelper() {
    }

    /**
     * 抛出数据库异常并指定异常信息
     * <p>
     * Throw a database exception and specify the exception information
     *
     * @param message
     */
    public static void throwDataBaseException(String message) {
        throw new DataBaseException(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    /**
     * 抛出服务异常并指定异常信息
     * <p>
     * Throw a service exception and specify the exception information
     *
     * @param message
     */
    public static void throwServiceException(String message) {
        throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    /**
     * 抛出服务异常并指定状态和异常信息
     * <p>
     * Throw a service exception and specify the status and exception information
     *
     * @param status
     * @param message
     */
    public static void throwServiceException(HttpStatus status, String message) {
        throw new ServiceException(status, message);
    }

    /**
     * 抛出aop异常并指定异常信息
     * <p>
     * Throw aop exception and specify the exception information
     *
     * @param message
     */
    public static void throwAopException(String message) {
        throw new AopException(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    /**
     * 抛出帮助异常并指定异常信息
     * <p>
     * Throw help exception and specify the exception information
     *
     * @param message
     */
    public static void throwHelperException(String message) {
        throw new HelperException(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    /**
     * 抛出弃用异常
     * <p>
     * Throw help deprecated exception
     */
    public static void throwDeprecatedException() {
        throw new HelperException(HttpStatus.INTERNAL_SERVER_ERROR, "This feature has been deprecated!");
    }

    /**
     * 抛出策略暂未支持异常
     * <p>
     * Throwing strategy does not support exceptions yet
     */
    public static void throwStrategyUnsupportedException() {
        throw new StrategyException(HttpStatus.INTERNAL_SERVER_ERROR, "This strategy is not yet supported!");
    }

    /**
     * 抛出策略失效异常
     * <p>
     * Throw strategy invalid exception
     */
    public static void throwStrategyInvalidException() {
        throw new StrategyException(HttpStatus.INTERNAL_SERVER_ERROR, "The strategy is not available!");
    }
}
