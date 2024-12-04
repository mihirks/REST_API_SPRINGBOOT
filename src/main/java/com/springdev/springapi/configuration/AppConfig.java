package com.springdev.springapi.configuration;

import com.springdev.springapi.DB;
import com.springdev.springapi.DevDB;
import com.springdev.springapi.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode" ,havingValue = "production")
    public DB getProdData(){
        return new ProdDB();
    }
    @Bean
    @ConditionalOnProperty(name = "project.mode" ,havingValue = "development")
    public DB getDevData(){
        return new DevDB();
    }

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
