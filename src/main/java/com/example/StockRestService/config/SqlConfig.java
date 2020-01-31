package com.example.StockRestService.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:stock.properties")
@ConfigurationProperties(prefix = "sql")
@Component
@Data
public class SqlConfig {

    private String recentStockEarning;
    private String allReferenceData;


}
