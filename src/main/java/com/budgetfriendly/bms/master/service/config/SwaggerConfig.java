package com.budgetfriendly.bms.master.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Budget Management System Application master api's")
                .description("Budget Management System Application Read, Master Data Write and update operations.")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.budgetfriendly.bms.master.service.controller"))
                .build()
                .apiInfo(apiInfo());
    }
}

