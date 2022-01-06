package com.budgetfriendly.bms.master.service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
