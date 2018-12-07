package com.pierceecom.blog.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Sets.newHashSet;

@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/posts/*"))
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo()).protocols(newHashSet("http"));
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Pierce AB Blog").description("Desc").version("1").build();
    }
}
