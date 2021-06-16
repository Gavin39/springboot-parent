package com.gavin.springboot.exception;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import java.io.Serializable;
import static com.gavin.springboot.helper.StringHelper.merge;


/**
 * @author Gavin
 * @date 2021/6/15 15:07
 * @since 1.0.0
 */
public abstract class GenericException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -1375093631909763541L;
    private static final Logger LOG = LoggerFactory.getLogger(GenericException.class);
    private final int code;
    private static final String ASSERT = "Assert";

    public GenericException(int code, String message) {
        super(message);
        this.code = code;
    }

    public GenericException(HttpStatus status, String message) {

        super(merge(status.getReasonPhrase(), ": ", message));
        this.code = status.value();
        methodLog(message);
    }

    /**
     * 方法调用日志打印
     *
     * @param message
     */
    private void methodLog(String message) {
        if (StringUtils.isNotBlank(message)) {

            StackTraceElement[] stackTrace = this.getStackTrace();
            if (stackTrace.length > 1) {
                for (StackTraceElement stackTraceElement : stackTrace) {

                    String className = stackTraceElement.getClassName();
                    boolean isThrowable = false;
                    try {
                        isThrowable = Class.forName(className).isAssignableFrom(Throwable.class);
                    } catch (ClassNotFoundException e) {
                        LOG.error("<init> fail!", e);
                    }
                    boolean isAssert = className.endsWith(ASSERT);
                    if (!isThrowable && !isAssert) {

                        LOG.info(merge("throw method -> ", className, "#", stackTraceElement.getMethodName()));
                        return;
                    }
                }
            }
        }
    }

    public GenericException(String message) {

        this(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public int getCode() {
        return code;
    }
}
