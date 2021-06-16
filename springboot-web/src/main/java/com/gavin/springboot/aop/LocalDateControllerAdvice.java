package com.gavin.springboot.aop;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.gavin.springboot.constants.DateConst.*;

/**
 * @author Gavin
 * @date 2021/1/8 18:37
 * @since 1.0.0
 */
@ControllerAdvice
public class LocalDateControllerAdvice {

    @InitBinder
    public void bindDate(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)));
            }
        });
        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(LocalDateTime.parse(text, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)));
            }
        });
        binder.registerCustomEditor(LocalTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(LocalTime.parse(text, DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)));
            }
        });
    }

}
