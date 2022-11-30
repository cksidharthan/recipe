package com.abn.recipe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/*
  * This class is used to configure Swagger for the application
  */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.abn.recipe.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(metaData());
  }

  private ApiInfo metaData() {
    ApiInfo apiInfo = new ApiInfo(
        "Recipe API",
        "Backend for Recipe System",
        "1.0",
        "Terms of service",
        new Contact("Sid", "https://cksidharthan.github.io", "cksidharthan@duck.com"),
        "",
        "", Collections.emptyList());
    return apiInfo;
  }

}
