package com.example.bank.config;

import io.swagger.annotations.ApiParam;
import lombok.Getter;

@Getter
public class SwaggerPageable {

    @ApiParam(value = "Número da pagina", example = "0")
    private Integer page;

}
