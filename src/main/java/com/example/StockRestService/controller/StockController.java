package com.example.StockRestService.controller;

import com.example.StockRestService.config.AppProperties;
import com.example.StockRestService.config.SqlConfig;
import com.example.StockRestService.dao.IGenericDao;
import com.example.StockRestService.dao.IStockDao;
import com.example.StockRestService.entity.StockEntity;
import com.example.StockRestService.entity.StockPerformanceEntity;
import com.example.StockRestService.entity.StockStartEndPriceEntity;
import com.example.StockRestService.entity.earning.Earning;
import com.example.StockRestService.entity.earning.calendar.EarningsItem;
import com.example.StockRestService.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@CrossOrigin
@RestController
@Slf4j
public class StockController
{

    @Qualifier("selectStockInformation")
    @Autowired
    private String s;

    @Autowired
    private IStockDao dao;

    @Autowired
    private IGenericDao genericDao;

    @Autowired
    private StockService stockService;

    @Autowired
    private SqlConfig sqlConfig;

    @Autowired private AppProperties appProperties;

/*    @Value("${finnhub.api.keys}")
    private List<String> finnHubApiKeys;*/

    AtomicInteger atomicInteger = new AtomicInteger(1);

    @RequestMapping("/test")
    public String test(){
        return sqlConfig.getRecentStockEarning();
    }

    @RequestMapping("/getRecentEarning")
    public List<Map<String,Object>> getRecentEarning(){

        return stockService.getRecentEarningReport();
/*
        return genericDao.getListMap(sqlConfig.getRecentStockEarning());
*/
    }



    @RequestMapping("/daoTest")
    public List<StockEntity> daoTest(){
        return dao.getStocks();
    }

    @RequestMapping("/testStartEnd")
    public List<StockStartEndPriceEntity> daoTest1(){
        return dao.getStockStartEndPriceEntity();
    }

    @RequestMapping("/testStartEndAdjusted")
    public List<StockStartEndPriceEntity> daoTest2(){
        return dao.getStockStartEndPriceAdjustedEntity();
    }

    @RequestMapping(value="/getStockPerformance/{stock}",method= RequestMethod.GET)
    public StockPerformanceEntity daoTest2(@PathVariable String stock){
        System.out.println(dao.getStockPerformance(stock));

        return dao.getStockPerformance(stock);
    }


/*    @RequestParam("/getRecentEarningDate")*/

    @RequestMapping(value="/loadStockInfoTodb", method= RequestMethod.POST)
    public void retriveAndStore(@RequestBody  String stockTicker){


        String key = appProperties.getFinnHubApiKeys().get(atomicInteger.getAndIncrement()%3);
        stockService.processStockBasicInfo(stockTicker.toUpperCase());
        stockService.processDailyCandle(stockTicker,key);
        stockService.processStockEarningInfo(stockTicker,key);
        stockService.processStockTechnicalIndicator(stockTicker,key);
        stockService.processStockNewsSentiment(stockTicker,key);
    }

    @RequestMapping(value="/loadEarningCalendar", method= RequestMethod.POST)
    public void loadEarningCalendar(){

        String key = appProperties.getFinnHubApiKeys().get(atomicInteger.getAndIncrement()%3);

        List<EarningsItem> list= stockService.processEarningCalendar(key);

        for(EarningsItem earningsItem: list) {

            String[] symbolCountry = earningsItem.getCode().split(Pattern.quote("."));
            if (symbolCountry.length == 2) {
                try {
                    StopWatch stopWatch = new StopWatch();

                    stopWatch.start();
                    key = appProperties.getFinnHubApiKeys().get(atomicInteger.getAndIncrement()%3);
                    log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                    log.info(String.format("Start processing stock|stock=%s|key=%s",symbolCountry[0],key ));
                    if(stockService.processStockBasicInfo(symbolCountry[0].toUpperCase())){
                        try{
                            stockService.processStockEarningInfo(symbolCountry[0],key);
                        }
                        catch(HttpClientErrorException e){
                            e.printStackTrace();
                            for(int i=0; i<2; i++){
                                try{
                                    TimeUnit.SECONDS.sleep(10);
                                    stockService.processStockEarningInfo(symbolCountry[0],key);
                                }
                                catch(HttpClientErrorException e1){
                                    log.error(e1.getMessage());
                                }
                            }
                        }
                        try{
                            stockService.processDailyCandle(symbolCountry[0],key);
                        }
                        catch(HttpClientErrorException e){
                            e.printStackTrace();
                            for(int i=0; i<2; i++){
                                try{
                                    TimeUnit.SECONDS.sleep(10);
                                    stockService.processDailyCandle(symbolCountry[0],key);
                                }
                                catch(HttpClientErrorException e1){
                                    log.error(e1.getMessage());
                                }
                            }
                        }
                        try{
                            stockService.processStockTechnicalIndicator(symbolCountry[0],key);

                        }
                        catch(HttpClientErrorException e){
                            e.printStackTrace();
                            for(int i=0; i<2; i++){
                                try{
                                    TimeUnit.SECONDS.sleep(10);
                                    stockService.processStockTechnicalIndicator(symbolCountry[0],key);
                                }
                                catch(HttpClientErrorException e1){
                                    log.error(e1.getMessage());
                                }
                            }
                        }
                        try{
                            stockService.processStockNewsSentiment(symbolCountry[0],key);
                        }
                        catch(HttpClientErrorException e){
                            e.printStackTrace();
                            for(int i=0; i<2; i++){
                                try{
                                    TimeUnit.SECONDS.sleep(10);
                                    stockService.processStockNewsSentiment(symbolCountry[0],key);
                                }
                                catch(HttpClientErrorException e1){
                                    log.error(e1.getMessage());
                                }
                            }
                        }
                    }
                    stopWatch.stop();
                    log.info(String.format("End processing stock|stock=%s|key=%s|time=%d",symbolCountry[0],key,stopWatch.getTotalTimeMillis() ));
                    log.info("--------------------------------------------------------");


                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Error processing stock|stock=" + symbolCountry[0] + "|message="+ e.getMessage());
                    log.info("********************************************************");

                }
            }
        }



    }


}
