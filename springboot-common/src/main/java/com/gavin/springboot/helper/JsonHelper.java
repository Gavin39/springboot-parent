package com.gavin.springboot.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Gavin
 * @date 2021/6/15 14:59
 * @since 1.0.0
 */
@Slf4j
public final class JsonHelper {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonHelper() {
    }

    /**
     * 对象转换成json
     * <p>
     * Convert object to json
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        if (obj == null) {

            return null;
        }
        if (obj.getClass() == String.class) {

            return (String) obj;
        }
        String str = null;
        try {

            str = MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {

            log.error("json serialization error:" + obj, e);
        }
        return str;
    }

    /**
     * json转换成对象
     * <p>
     * Convert json to object
     *
     * @param json
     * @param cls
     * @param <B>
     * @return
     */
    public static <B> B toObject(String json, Class<B> cls) {

        B bean = null;
        try {
            bean = MAPPER.readValue(json, cls);
        } catch (IOException e) {
            log.error("json parse error:" + json, e);
        }
        return bean;
    }

    /**
     * json转换成对象list
     * <p>
     * Convert json to object list
     *
     * @param json
     * @param cls
     * @param <E>
     * @return
     */
    public static <E> List<E> toList(String json, Class<E> cls) {
        List<E> list = null;
        try {
            list = MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(List.class, cls));
        } catch (IOException e) {
            log.error("json parse error:" + json, e);
        }
        return list;
    }

    /**
     * json转换成对象set
     * <p>
     * Convert json to object set
     *
     * @param json
     * @param cls
     * @param <E>
     * @return
     */
    public static <E> Set<E> toSet(String json, Class<E> cls) {
        Set<E> set = null;
        try {
            set = MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(Set.class, cls));
        } catch (IOException e) {
            log.error("json parse error:" + json, e);
        }
        return set;
    }

    /**
     * json转换成map
     * <p>
     * Convert json to map
     *
     * @param json
     * @param kCls
     * @param vCls
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> toMap(String json, Class<K> kCls, Class<V> vCls) {
        Map<K, V> map = null;
        try {
            map = MAPPER.readValue(json, MAPPER.getTypeFactory().constructMapType(LinkedHashMap.class, kCls, vCls));
        } catch (IOException e) {
            log.error("json parse error:" + json, e);
        }
        return map;
    }

    /**
     * json转换成自定义类型
     * <p>
     * Convert json to Custom type
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        T t = null;
        try {
            t = MAPPER.readValue(json, type);
        } catch (IOException e) {
            log.error("json parse error:" + json, e);
        }
        return t;
    }
}
