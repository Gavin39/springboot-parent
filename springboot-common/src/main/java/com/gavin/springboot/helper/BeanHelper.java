package com.gavin.springboot.helper;


import com.gavin.springboot.exception.HelperException;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Gavin
 * @date 2021/6/15 15:03
 * @since 1.0.0
 */
@Slf4j
public final class BeanHelper {

    private static final String BEAN_PROCESS_ERROR = "bean process error";

    private BeanHelper() {
    }

    /**
     * 将源对象属性值拷贝到目标类型并返回目标实例
     * <p>
     * Copy the source object attribute value to the target type and return the target instance
     * <p>
     * {@link org.springframework.beans.BeanUtils#copyProperties(Object, Object)}
     *
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T copyProperties(Object source, Class<T> target) {
        try {

            T t = target.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source, t);
            return t;
        } catch (Exception e) {

            log.error("[copyProperties] data convert fail，target Object {} construct exception ", target.getName(), e);
            throw new HelperException(BEAN_PROCESS_ERROR);
        }
    }

    /**
     * 通过json序列化将原对象list装换成目标类型的实例list
     * <p>
     * Replace the original object list with the target type instance list through json serialization
     * <p>
     * {@link JsonHelper#toJson(Object)}
     * {@link JsonHelper#toBean(String, Class)}
     *
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> List<T> toBeans(List<?> source, Class<T> target) {

        List<T> list = new ArrayList<>();
        for (Object o : source) {

            T t = JsonHelper.toBean(JsonHelper.toJson(o), target);
            list.add(t);
        }

        source.clear();
        return list;
    }


    /**
     * 通过json序列化将bean装换成map
     * <p>
     * Replace bean into map through json serialization
     * <p>
     * {@link JsonHelper#toJson(Object)}
     * {@link JsonHelper#toMap(String, Class, Class)}}
     *
     * @param bean
     * @return
     */
    public static Map<String, Object> toMap(Object bean) {

        return JsonHelper.toMap(JsonHelper.toJson(bean), String.class, Object.class);
    }

    /**
     * 将源对象list中的对象值拷贝到目标类型并返回目标实例list
     * <p>
     * Copy the object value in the source object list to the target type and return the target instance list
     * <p>
     * {@link #copyProperties(Object, Class)}
     *
     * @param sourceList
     * @param target
     * @param <T>
     * @return
     */
    public static <T> List<T> copyWithCollection(List<?> sourceList, Class<T> target) {

        try {

            return sourceList.stream().map(s -> copyProperties(s, target)).collect(Collectors.toList());
        } catch (Exception e) {

            log.error("[copyWithCollection] data convert fail，target Object {} construct exception ", target.getName(), e);
            throw new HelperException(BEAN_PROCESS_ERROR);
        }
    }

    /**
     * 将源对象set中的对象值拷贝到目标类型并返回目标实例set
     * <p>
     * Copy the object value in the source object set to the target type and return the target instance set
     * <p>
     * {@link #copyProperties(Object, Class)}
     *
     * @param sourceList
     * @param target
     * @param <T>
     * @return
     */
    public static <T> Set<T> copyWithCollection(Set<?> sourceList, Class<T> target) {

        try {

            return sourceList.stream().map(s -> copyProperties(s, target)).collect(Collectors.toSet());
        } catch (Exception e) {

            log.error("[copyWithCollection] data convert fail，target Object {} construct exception ", target.getName(), e);
            throw new HelperException(BEAN_PROCESS_ERROR);
        }
    }
}
