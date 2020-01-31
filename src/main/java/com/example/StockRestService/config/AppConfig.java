package com.example.StockRestService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

@Configuration
@ImportResource("classpath:sql/*")
public class AppConfig {

    @Autowired
    private AppProperties appProperties;

    @Bean
    public DriverManagerDataSource fdeDataSource(){
        System.out.println(appProperties.toString());
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName(appProperties.getSqlDriverClass());
        ds.setUrl(appProperties.getSqlUrl());
        ds.setUsername(appProperties.getSqlUser());
        ds.setPassword(appProperties.getSqlPassword());
        return ds;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

/*    @Bean public ConversionService conversionService() {
        return new DefaultConversionService();
    }*/

}
