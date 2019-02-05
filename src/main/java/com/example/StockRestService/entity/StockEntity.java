package com.example.StockRestService.entity;

import java.util.Objects;

public class StockEntity {

    private String stockSymbol;
    private String name;
    private String sector;
    private String industry;

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "StockEntity{" +
                "stockSymbol='" + stockSymbol + '\'' +
                ", name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockEntity that = (StockEntity) o;
        return Objects.equals(stockSymbol, that.stockSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockSymbol);
    }
}
