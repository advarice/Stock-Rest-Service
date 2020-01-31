package com.example.StockRestService.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix="srs")
@Data
@Component
public class AppProperties {

    private String sqlDriverClass;

    private String sqlUrl;

    private String sqlUser;

    private String sqlPassword;

    private List<String> finnHubApiKeys;


}
