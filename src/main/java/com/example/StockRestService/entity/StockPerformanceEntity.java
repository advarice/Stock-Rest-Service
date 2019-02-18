package com.example.StockRestService.entity;

public class StockPerformanceEntity {
    private String stockSymbol;
    private double day7AvgClose;
    private double day7AvgVolume;
    private double day30AvgClose;
    private double day30AvgVolume;
    private double day60AvgClose;
    private double day60AvgVolume;
    private double day90AvgClose;
    private double currentClose;
    private double currentVolume;

    private StockEntity stockEntity;

    public double getCurrentClose() {
        return currentClose;
    }

    public void setCurrentClose(double currentClose) {
        this.currentClose = currentClose;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(double currentVolume) {
        this.currentVolume = currentVolume;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public double getDay30AvgClose() {
        return day30AvgClose;
    }

    public void setDay30AvgClose(double day30AvgClose) {
        this.day30AvgClose = day30AvgClose;
    }

    public double getDay30AvgVolume() {
        return day30AvgVolume;
    }

    public void setDay30AvgVolume(double day30AvgVolume) {
        this.day30AvgVolume = day30AvgVolume;
    }

    public double getDay60AvgClose() {
        return day60AvgClose;
    }

    public void setDay60AvgClose(double day60AvgClose) {
        this.day60AvgClose = day60AvgClose;
    }

    public double getDay60AvgVolume() {
        return day60AvgVolume;
    }

    public void setDay60AvgVolume(double day60AvgVolume) {
        this.day60AvgVolume = day60AvgVolume;
    }

    public double getDay90AvgClose() {
        return day90AvgClose;
    }

    public void setDay90AvgClose(double day90AvgClose) {
        this.day90AvgClose = day90AvgClose;
    }

    public double getDay90AvgVolume() {
        return day90AvgVolume;
    }

    public void setDay90AvgVolume(double day90AvgVolume) {
        this.day90AvgVolume = day90AvgVolume;
    }

    private double day90AvgVolume;

    public double getDay7AvgClose() {
        return day7AvgClose;
    }

    public void setDay7AvgClose(double day7AvgClose) {
        this.day7AvgClose = day7AvgClose;
    }

    public double getDay7AvgVolume() {
        return day7AvgVolume;
    }

    public void setDay7AvgVolume(double day7AvgVolume) {
        this.day7AvgVolume = day7AvgVolume;
    }

    public StockEntity getStockEntity() {
        return stockEntity;
    }

    public void setStockEntity(StockEntity stockEntity) {
        this.stockEntity = stockEntity;
    }

    @Override
    public String toString() {
        return "StockPerformanceEntity{" +
                "stockSymbol='" + stockSymbol + '\'' +
                ", day7AvgClose=" + day7AvgClose +
                ", day7AvgVolume=" + day7AvgVolume +
                ", day30AvgClose=" + day30AvgClose +
                ", day30AvgVolume=" + day30AvgVolume +
                ", day60AvgClose=" + day60AvgClose +
                ", day60AvgVolume=" + day60AvgVolume +
                ", day90AvgClose=" + day90AvgClose +
                ", currentClose=" + currentClose +
                ", currentVolume=" + currentVolume +
                ", stockEntity=" + stockEntity +
                ", day90AvgVolume=" + day90AvgVolume +
                '}';
    }
}
