package com.gavin.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Gavin
 * @date 2021/6/3 15:05
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 负责接口文档的呈现以及接口的配置
     *
     * @return
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")// 要将那些请求路径映射到swagger文档中
                .select()// api选择构建器
                .apis(RequestHandlerSelectors.basePackage("com.gavin.springboot.controller"))// 哪个包下的http接口配置到swagger文档中
                .paths(PathSelectors.any())//任何一个接口都配置到swagger文档中
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档标题(API名称)
                .title("接口规范")
                //文档描述
                .description("接口说明")
                //版本号
                .version("1.0.0")
                .build();
    }

}
