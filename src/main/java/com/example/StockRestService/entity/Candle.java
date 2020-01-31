package com.example.StockRestService.entity;

import lombok.Data;

@Data
public class Candle {
    private Double close;
    private Double open;
    private long volume;
    private Double high;
    private Double low;
}
