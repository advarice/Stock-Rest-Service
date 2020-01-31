package com.example.StockRestService.service;


import com.example.StockRestService.common.Commons;
import com.example.StockRestService.config.SqlConfig;
import com.example.StockRestService.dao.IGenericDao;
import com.example.StockRestService.dao.IStockDao;
import com.example.StockRestService.entity.Candle;
import com.example.StockRestService.entity.DailyCandle;
import com.example.StockRestService.entity.candle.daily.CandleRaw;
import com.example.StockRestService.entity.earning.Earning;
import com.example.StockRestService.entity.earning.calendar.EarningCalendar;
import com.example.StockRestService.entity.earning.calendar.EarningsItem;
import com.example.StockRestService.entity.news.NewsSentiment;
import com.example.StockRestService.entity.stockBaisc.StockBasic;
import com.example.StockRestService.entity.stockSummary.StockSummary;
import com.example.StockRestService.entity.technical.TechnicalIndicator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StockService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    IStockDao stockDao;

    private static String FINNHUB_DAILY_CANDLE_URL = "https://finnhub.io/api/v1/stock/candle?symbol=%s&resolution=D&count=1000&token=%s";


    @Autowired
    private SqlConfig sqlConfig;

    @Autowired
    private IGenericDao genericDao;

    AtomicLong atomicLong = new AtomicLong(1);

    public Boolean processStockBasicInfo(String stockTicker){

/*
        StockSummary stockSummary = restTemplate.getForObject(String.format("https://api.nasdaq.com/api/quote/%s/info?assetclass=stocks", stockTicker), StockSummary.class);
*/

        StockBasic stockBasic = restTemplate.getForObject(String.format("https://api.nasdaq.com/api/quote/%s/info?assetclass=stocks", stockTicker), StockBasic.class);
        StockSummary stockSummary = restTemplate.getForObject(String.format("https://api.nasdaq.com/api/quote/%s/summary?assetclass=stocks", stockTicker), StockSummary.class);

        stockSummary.getData().setCompanyName(stockBasic.getData().getCompanyName());
        try{
            int impacted = stockDao.insertStock(stockSummary);
            if(impacted ==0){
                log.info("Duplicate stock data, not inserting.");
            }
        }
        catch(DuplicateKeyException e){
            log.error("Duplicate data, no inserting.");
        }
        catch(Exception e){

            e.printStackTrace();
            return false;
        }
        try{
            int impacted = stockDao.inserSummary(stockSummary);
        }
        catch(DuplicateKeyException e){
            log.info("Duplicate summary data, not inserting.");
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        log.info(String.format("Finish processing baisc info|stock=%s",stockTicker));
        return true;
    }

    public void processDailyCandle(String stockTicker,String key){
        CandleRaw candleRaw = restTemplate.getForObject(String.format(FINNHUB_DAILY_CANDLE_URL, stockTicker,key), CandleRaw.class);
        List<DailyCandle> dailyCandleList = new ArrayList<>();
        for(int i = 0; i< candleRaw.getT().size(); i++){
            DailyCandle dailyCandle = new DailyCandle();

            Candle candle = new Candle();
            Date date = new Date(candleRaw.getT().get(i)*1000);
            candle.setHigh(candleRaw.getH().get(i));
            candle.setLow(candleRaw.getL().get(i));
            candle.setClose(candleRaw.getC().get(i));
            candle.setOpen(candleRaw.getO().get(i));
            candle.setVolume(candleRaw.getV().get(i));

            dailyCandle.setCandle(candle);
            dailyCandle.setDate(date);
            dailyCandle.setStockSymbol(stockTicker);
            dailyCandleList.add(dailyCandle);
        }
        try{
            stockDao.insertDailyCandle(dailyCandleList);
        }
        catch(Exception e){
            if(e instanceof  SQLIntegrityConstraintViolationException){
                log.error("Duplicate entry for primary key: " + e.getMessage());
            }
            else{
                log.error("Unknown exception: " + e.getMessage());
            }
        }



    }

    public void processStockEarningInfo(String stockTicker, String key) {
        List<Earning> earnings = new ArrayList<>(Arrays.asList(restTemplate.getForEntity(String.format("https://finnhub.io/api/v1/stock/earnings?symbol=%s&token=%s", stockTicker,key), Earning[].class).getBody()));
        List<Earning> exitistingEarnings = stockDao.getExistingEarning(stockTicker);

        earnings.addAll(exitistingEarnings);
        Set<Earning> earningSet = new LinkedHashSet();
        earningSet.addAll(earnings);
        earnings = earningSet.stream().collect(Collectors.toList());
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            stockDao.insertStockReferenceData(stockTicker, Commons.EARANING_DATA, objectMapper.writeValueAsString(earnings));
            log.info(String.format("Finish processing earning info|stock=%s",stockTicker));

        }
        catch(Exception e){
            log.error("Error converting Earning object to json string");
        }


    }


    public void processStockTechnicalIndicator(String stockTicker,String key) {
        TechnicalIndicator technicalIndicator = restTemplate.getForObject(String.format("https://finnhub.io/api/v1/scan/technical-indicator?symbol=%s&resolution=D&token=%s", stockTicker, key), TechnicalIndicator.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            stockDao.insertStockReferenceData(stockTicker, Commons.TECHNICAL_INDICATOR, objectMapper.writeValueAsString(technicalIndicator));
            log.info(String.format("Finish processing technical indicators|stock=%s",stockTicker));

        }
        catch(Exception e){
            log.error("Error converting Earning object to json string");
        }
    }

    public void processStockNewsSentiment(String stockTicker,String key) {
        NewsSentiment newsSentiment = restTemplate.getForObject(String.format("https://finnhub.io/api/v1/news-sentiment?symbol=%s&token=%s", stockTicker,key), NewsSentiment.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            stockDao.insertStockReferenceData(stockTicker, Commons.NEWS_SENTIMENT, objectMapper.writeValueAsString(newsSentiment));
            log.info(String.format("Finish processing news sentiment|stock=%s",stockTicker));

        }
        catch(Exception e){
            log.error("Error converting Earning object to json string");
        }
    }

    public List<EarningsItem> processEarningCalendar(String key){
        EarningCalendar earningCalendar = (restTemplate.getForObject(String.format("https://finnhub.io/api/v1/calendar/earnings?token=%s",key), EarningCalendar.class));
        List<EarningsItem> earningsItemList = earningCalendar.getEarningsCalendar().getEarnings()
                .stream().filter(earningsItem -> earningsItem.getCode().contains(".US"))
                .collect(Collectors.toList());



        stockDao.insertStockReferenceData(earningsItemList);
        return earningsItemList;

    }

    public List<Map<String,Object>> getRecentEarningReport(){

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,Object>> referenceData = genericDao.getListMap(sqlConfig.getAllReferenceData());

        for(Map<String, Object> data: referenceData ){
            Object newsSentimentData = data.get("new_sentiment");
            Object technicalIndicatorData = data.get("technical_indicator");
            Object earningData = data.get("earning_data");
            if(newsSentimentData!=null&&!newsSentimentData.toString().equals("")){
                try {
                    NewsSentiment newsSentiment= objectMapper.readValue(newsSentimentData.toString(), NewsSentiment.class);
                    data.put("new_sentiment", newsSentiment);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(technicalIndicatorData!=null&&!technicalIndicatorData.toString().equals("")){
                try {
                    TechnicalIndicator technicalIndicator = objectMapper.readValue(technicalIndicatorData.toString(), TechnicalIndicator.class);
                    data.put("technical_indicator", technicalIndicator);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(earningData!=null&&!earningData.toString().equals("")){
                try {
                    List<Earning> earningList = new ArrayList<>(Arrays.asList(objectMapper.readValue(earningData.toString(), Earning[].class)));
                    data.put("earning_data", earningList);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



        return referenceData;
    }

}
