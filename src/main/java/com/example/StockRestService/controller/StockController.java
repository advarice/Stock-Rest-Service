package com.example.StockRestService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController
{

    @Qualifier("selectStockInformation")
    @Autowired
    String s;

    @RequestMapping("/test")
    public String test(){
        return s;
    }
}
