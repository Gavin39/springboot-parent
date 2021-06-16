package com.gavin.springboot.helper;

import com.gavin.springboot.exception.HelperException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Gavin
 * @date 2021/6/15 15:34
 * @since 1.0.0
 */
@Component
public final class SpringAwareHelper implements InitializingBean, ApplicationContextAware {

    private SpringAwareHelper() {
    }

    private static ApplicationContext applicationContext;
    private static SpringAwareHelper self;


    /**
     * {@link ApplicationContext}
     *
     * @return
     */
    public static ApplicationContext applicationContext() {

        selfInspection();
        return applicationContext;
    }

    /**
     * 自检
     */
    private static void selfInspection() {
        if (Objects.isNull(self)) {

            throw new HelperException("[selfInspection] 请在spring环境下使用!");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        SpringAwareHelper.self = this;
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {

        SpringAwareHelper.applicationContext = applicationContext;
    }
}
