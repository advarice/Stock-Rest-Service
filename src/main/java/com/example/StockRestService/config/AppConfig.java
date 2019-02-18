package com.example.StockRestService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

@Configuration
@ImportResource("classpath:sql/StockSqlBean.xml")
public class AppConfig {

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/stock_analysis");
        ds.setUsername("root");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
