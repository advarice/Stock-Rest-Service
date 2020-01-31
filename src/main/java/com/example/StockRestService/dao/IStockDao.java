package com.example.StockRestService.dao;

import com.example.StockRestService.entity.DailyCandle;
import com.example.StockRestService.entity.StockEntity;
import com.example.StockRestService.entity.StockPerformanceEntity;
import com.example.StockRestService.entity.StockStartEndPriceEntity;
import com.example.StockRestService.entity.earning.Earning;
import com.example.StockRestService.entity.earning.calendar.EarningsItem;
import com.example.StockRestService.entity.stockSummary.StockSummary;

import java.util.Date;
import java.util.List;

public interface IStockDao {
    public List<StockEntity> getStocks();

    public List<StockStartEndPriceEntity> getStockStartEndPriceEntity();

    List<StockStartEndPriceEntity> getStockStartEndPriceAdjustedEntity();

    StockPerformanceEntity getStockPerformance(String stock);

    int inserSummary(StockSummary stockSummary);

    int insertStock(StockSummary stockSummary);

    void insertDailyCandle(List<DailyCandle> dailyCandleList);

    public Date getLatestInsertDate(String stockSymbol);

    public List<Earning> getExistingEarning(String stockSymbol);


    public void insertStockReferenceData(String stockSymbol, String type, String earningData);

    void insertEarningCalendar(List<EarningsItem> earningsItemList);

    public void insertStockReferenceData(List<EarningsItem> earningsItemList);
}
