package com.gavin.springboot.helper;

/**
 * @author Gavin
 * @date 2021/6/15 15:07
 * @since 1.0.0
 */
public final class StringHelper {

    private static final ThreadLocal<StringBuilder> SB_TL = ThreadLocal.withInitial(StringBuilder::new);

    private StringHelper() {
    }

    /**
     * 合并字符串
     * <p>
     * Combine strings
     *
     * @param elements
     * @return
     */
    public static String merge(final Object... elements) {

        if (elements.length == 1) {
            return String.valueOf(elements[0]);
        }
        StringBuilder sb = SB_TL.get();
        for (Object element : elements) {

            sb.append(element);
        }
        final String result = sb.toString();
        sb.delete(0, sb.length());
        return result;
    }
}