package com.example.bank.config;

import com.example.bank.entity.Account;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.schema.AlternateTypeRules.newRule;


/**
 * The SwaggerConfig contain configs for API documentation .
 * Access by : http://localhost:8080/swagger-ui.html
 * @author  Elton Lopes
 * @version 1.0
 * @since   2021-08-21
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private TypeResolver typeResolver;

    private List<ResponseMessage> responseMessageForGET()
    {
        return new ArrayList<>() {{
        }};
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.bank.controller"))
                .paths(PathSelectors.any())
                .build().useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
                .directModelSubstitute(Pageable.class, SwaggerPageable.class)
                .ignoredParameterTypes()
                .alternateTypeRules(
                        newRule(typeResolver.resolve(Page.class,
                                typeResolver.resolve(ResponseEntity.class, Account.class)),
                                typeResolver.resolve(Account.class)))
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Bank Api")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Elton", "https://github.com/eltilopes/", "eltilopes@gmail.com"))
                .build();
    }

}