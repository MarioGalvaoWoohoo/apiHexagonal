package com.woohoo.apiHexagonal.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Api Juros Boleto")
                .description("Api para calcular juros de boleto vencido")
                .contact(new Contact()
                    .name("Mario George Galvão")
                    .email("geowebmaster@hotmail.com")
                        ).version("1.0.0"));
    }
}
