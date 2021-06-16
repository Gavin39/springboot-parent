package com.gavin.springboot.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Objects;

/**
 * @author Gavin
 * @date 2021/1/8 15:04
 * @since 1.0.0
 */
@Slf4j
public class LocalDateHelper {

    private LocalDateHelper() {}

    /**
     * 格式化日期时间
     *
     * @param localDateTime 日期时间
     * @return string
     */
    public static final String formatDateTime(LocalDateTime localDateTime, String pattern) {
        if (Objects.isNull(localDateTime)) {
            return StringUtils.EMPTY;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(localDateTime);
    }

    /**
     * 格式化日期
     *
     * @date 2020/1/15 10:18
     * @return String
     */
    public static final String formatDate(LocalDate localDate, String pattern) {
        if (Objects.isNull(localDate)) {
            return StringUtils.EMPTY;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(localDate);
    }

    /**
     * Date转LocalDate
     * @param date
     */
    public static LocalDate date2LocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Date转LocalDateTime
     * @param date
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * LocalDate转Date
     * @param localDate
     * @return
     */
    public static Date localDate2Date(LocalDate localDate) {
        if(null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * LocalDateTime转Date
     * @param localDateTime
     * @return
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        if(null == localDateTime) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 根据格式化日期字符串转为LocalDate
     *
     * @param localDateStr
     * @param pattern
     * @return
     */
    public static LocalDate parseLocalDate(String localDateStr, String pattern) {
        if (Objects.isNull(localDateStr)) {
            return null;
        }
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
            return LocalDate.parse(localDateStr, dtf);
        } catch (DateTimeParseException e) {
            log.error(e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * 根据格式化日期字符串转为LocalDateTime
     *
     * @param localDateTimeStr
     * @param pattern
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String localDateTimeStr, String pattern) {
        if (Objects.isNull(localDateTimeStr)) {
            return null;
        }
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
            return LocalDateTime.parse(localDateTimeStr, dtf);
        } catch (DateTimeParseException e) {
            log.error(e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * 获取日期当月的第几天
     *
     * @param day
     * @return
     */
    public static int getDayOfMonth(LocalDate day) {
        if (day == null) {
            return 0;
        }
        return day.getDayOfMonth();
    }

    /**
     * 获取日期当月的最大天数
     *
     * @param day
     * @return
     */
    public static int getDayCountOfMonth(LocalDate day) {
        if (day == null) {
            return 0;
        }
        return day.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param day1
     * @param day2
     * @return
     */
    public static boolean isSameDay(LocalDate day1, LocalDate day2) {
        if (!ObjectUtils.allNotNull(day1, day2)) {
            return false;
        }
        return day1.isEqual(day2);
    }

    /**
     * 判断两个日期是否是同一周
     *
     * @param day1
     * @param day2
     * @return
     */
    public static boolean isSameWeek(LocalDate day1, LocalDate day2) {
        if (!ObjectUtils.allNotNull(day1, day2)) {
            return false;
        }
        // 获取本周第一天
        LocalDate firstDay = day1.with(DayOfWeek.MONDAY);
        // 获取本周最后一天
        LocalDate lastDay = day1.with(DayOfWeek.SUNDAY);
        // 判断是否在统一范围内
        return !day2.isAfter(lastDay) && !day2.isBefore(firstDay);
    }

    /**
     * 判断两个日期是否是同一月
     *
     * @param day1
     * @param day2
     * @return
     */
    public static boolean isSameMonth(LocalDate day1, LocalDate day2) {
        if (!ObjectUtils.allNotNull(day1, day2)) {
            return false;
        }
        // 获取本周第一天
        LocalDate firstDay = day1.with(TemporalAdjusters.firstDayOfMonth());
        // 获取本周最后一天
        LocalDate lastDay = day1.with(TemporalAdjusters.lastDayOfMonth());
        // 判断是否在统一范围内
        return !day2.isAfter(lastDay) && !day2.isBefore(firstDay);
    }

}
