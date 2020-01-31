package com.example.StockRestService.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DailyCandle {

    private String stockSymbol;
    private Date date;
    private Candle candle;

}
