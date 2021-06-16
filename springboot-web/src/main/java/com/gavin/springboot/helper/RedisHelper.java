package com.gavin.springboot.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Gavin
 * @date 2021/6/15 15:34
 * @since 1.0.0
 */
@Component
@SuppressWarnings("unchecked")
public final class RedisHelper implements ApplicationContextAware {

    private static RedisTemplate<String, Object> template;
    private static final byte FAIL_FLAG = -1;

    private RedisHelper() {
    }

    /**
     * 利用环境初始化{@link RedisTemplate}
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        template = (RedisTemplate<String, Object>) applicationContext.getBean("redisTemplate");
    }

    /**
     * {@link RedisTemplate#hasKey(Object)}
     *
     * @param key
     * @return
     */
    public static boolean has(String key) {

        Boolean hasKey = template.hasKey(key);
        return Objects.nonNull(hasKey) && hasKey;
    }

    /**
     * {@link RedisTemplate#expire(Object, long, TimeUnit)}
     *
     * @param key
     * @param timeOut
     * @return
     */
    public static boolean expire(String key, long timeOut) {

        Boolean expire = template.expire(key, timeOut, TimeUnit.SECONDS);
        return Objects.nonNull(expire) && expire;
    }

    /**
     * {@link ValueOperations#get(Object)}
     *
     * @param key
     * @param <V>
     * @return
     */
    public static <V> V get(String key) {

        return (V) template.opsForValue().get(key);
    }

    /**
     * {@link ValueOperations#set(Object, Object)}
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {

        template.opsForValue().set(key, value);
    }

    /**
     * {@link ValueOperations#set(Object, Object, long, TimeUnit)} )}
     *
     * @param key
     * @param value
     * @param time
     */
    public static void set(String key, Object value, long time) {

        template.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * {@link RedisTemplate#delete(Object)}
     *
     * @param key
     * @return
     */
    public static boolean delete(String key) {

        Boolean delete = template.delete(key);
        return Objects.nonNull(delete) && delete;
    }

    /**
     * {@link RedisTemplate#delete(Collection)}
     *
     * @param keys
     * @return
     */
    public static long delete(Collection<String> keys) {

        Long delete = template.delete(keys);
        return Objects.nonNull(delete) ? delete : FAIL_FLAG;
    }
}
