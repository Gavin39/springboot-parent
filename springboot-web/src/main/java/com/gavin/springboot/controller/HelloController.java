package com.gavin.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gavin
 * @date 2021/6/2 16:46
 * @since 1.2.26
 */

@RequestMapping("hello")
@RestController
@Api(tags = "Hello接口")
public class HelloController {

    @ApiOperation("hello world接口")
    @GetMapping("/world")
    public void helloWorld() {
        System.out.println("hello world~!");
    }

}
