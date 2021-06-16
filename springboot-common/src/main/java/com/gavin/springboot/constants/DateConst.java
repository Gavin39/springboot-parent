package com.gavin.springboot.constants;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Gavin
 * @date 2021/1/19 17:48
 * @since 1.0.0
 */
public class DateConst {

    /** 默认日期时间格式 */
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** 默认日期格式 */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /** 默认时间格式 */
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    /** 默认时区 */
    public static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone("GMT+08:00");

    /** 年月日时分秒毫秒 */
    public static final String DATE_TIME_PATTERN = "yyyyMMddHHmmssSSS";

    /** 时间格式转换 */
    public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT, Locale.CHINA);

    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT, Locale.CHINA);

    public static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT, Locale.CHINA);

}
