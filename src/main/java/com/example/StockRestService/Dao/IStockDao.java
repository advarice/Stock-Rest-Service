package com.example.StockRestService.Dao;

import com.example.StockRestService.entity.StockEntity;
import com.example.StockRestService.entity.StockPerformanceEntity;
import com.example.StockRestService.entity.StockStartEndPriceEntity;

import java.util.List;

public interface IStockDao {
    public List<StockEntity> getStocks();

    public List<StockStartEndPriceEntity> getStockStartEndPriceEntity();

    List<StockStartEndPriceEntity> getStockStartEndPriceAdjustedEntity();

    StockPerformanceEntity getStockPerformance(String stock);
}
