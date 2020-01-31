package com.example.StockRestService.scheduler;

import com.example.StockRestService.config.AppProperties;
import com.example.StockRestService.dao.IGenericDao;
import com.example.StockRestService.entity.earning.Earning;
import com.example.StockRestService.entity.earning.calendar.EarningsItem;
import com.example.StockRestService.service.StockService;
import jersey.repackaged.com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@Slf4j
@Service
public class StockProcessingScheduler {

    @Autowired
    private IGenericDao genericDao;

    @Autowired
    private StockService stockService;

/*    @Value("${finnhub.api.keys}")
    private List<String> finnHubApiKeys;*/

    @Autowired
            private AppProperties appProperties;

    AtomicInteger atomicInteger = new AtomicInteger(1);

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Scheduled(cron = "0 * * * 1-5 ?")
    public void cronJobSch() throws Exception {
        System.out.println("Cron job running at: " + new Date());
    }

    public void processMissing(){
        List<Map<String,Object>> stockList = genericDao.getListMap("select * from latest_news_sentiment where date");
        for(Map<String, Object> map : stockList){

            String stockSymbol = map.get("stock_symbol").toString();
            Date date = (Date) map.get("date");
            String key = appProperties.getFinnHubApiKeys().get(atomicInteger.getAndIncrement()%3);
            String dateStr= dateFormat.format(date);
            String todayStr = dateFormat.format(new Date());
            if(!dateFormat.format(date).equals(dateFormat.format(new Date()))){
                try{
                    stockService.processStockNewsSentiment(stockSymbol,key);
                }
                catch(HttpClientErrorException e){
                    e.printStackTrace();
                    for(int i=0; i<3; i++){
                        try{
                            Thread.sleep(60000);
                            stockService.processStockNewsSentiment(stockSymbol,key);
                        }
                        catch(HttpClientErrorException | InterruptedException e1){
                            log.error(e1.getMessage());
                        }
                    }
                }
            }
            else{
                log.info("Skipping Stock=" + stockSymbol);
            }
        }
    }

    public void processMissingIndicator(){
        List<Map<String,Object>> stockList = genericDao.getListMap("select * from latest_technical_indicator");
        for(Map<String, Object> map : stockList){
            String stockSymbol = map.get("stock_symbol").toString();
            Date date = (Date) map.get("date");
            String key = appProperties.getFinnHubApiKeys().get(atomicInteger.getAndIncrement()%3);
            String dateStr= dateFormat.format(date);
            String todayStr = dateFormat.format(new Date());
            if(!dateFormat.format(date).equals(dateFormat.format(new Date()))){
                try{
                    stockService.processStockTechnicalIndicator(stockSymbol,key);
                }
                catch(HttpClientErrorException e){
                    e.printStackTrace();
                    for(int i=0; i<3; i++){
                        try{
                            Thread.sleep(60000);
                            stockService.processStockTechnicalIndicator(stockSymbol,key);
                        }
                        catch(HttpClientErrorException | InterruptedException e1){
                            log.error(e1.getMessage());
                        }
                    }
                }
            }
            else{
                log.info("Skipping Stock=" + stockSymbol);
            }
        }
    }


    public void processDailyStock(){




        List<EarningsItem> list = stockService.processEarningCalendar(appProperties.getFinnHubApiKeys().get(atomicInteger.getAndIncrement()%3));
        for(EarningsItem item: list){
            try{
                String[] symbolCountry = item.getCode().split(Pattern.quote("."));
                stockService.processStockBasicInfo(symbolCountry[0]);
            }
            catch(Exception e){
                log.error(e.getMessage());
            }

        }


        List<Map<String,Object>> stockList = genericDao.getListMap("select * from latest_stock_summary;");

        log.info("START Processing stockList|size="+ stockList.size());
        AtomicInteger processed = new AtomicInteger(0);

        ThreadFactory tf = new ThreadFactoryBuilder().setNameFormat("Thread --%d").build();
        ExecutorService executorService= Executors.newFixedThreadPool(6);
        for(Map<String,Object> stock: stockList){
            Runnable r = ()->{
                String key = appProperties.getFinnHubApiKeys().get(atomicInteger.getAndIncrement()%3);
                long lStartTime = System.currentTimeMillis();
                String stockSymbol = stock.get("stock_symbol").toString();
                log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                log.info(String.format("Start processing stock|stock=%s|key=%s",stockSymbol,key ));
                if(stockService.processStockBasicInfo(stockSymbol.toUpperCase())){
                    try{
                        stockService.processStockEarningInfo(stockSymbol,key);
                    }
                    catch(HttpClientErrorException e){
                        e.printStackTrace();
                        for(int i=0; i<2; i++){
                            try{
                                Thread.sleep(10000);
                                stockService.processStockEarningInfo(stockSymbol,key);
                            }
                            catch(HttpClientErrorException | InterruptedException e1){
                                log.error(e1.getMessage());
                            }
                        }
                    }
                    try{
                        stockService.processDailyCandle(stockSymbol,key);
                    }
                    catch(HttpClientErrorException e){
                        e.printStackTrace();
                        for(int i=0; i<2; i++){
                            try{
                                Thread.sleep(10000);
                                stockService.processDailyCandle(stockSymbol,key);
                            }
                            catch(HttpClientErrorException | InterruptedException e1){
                                log.error(e1.getMessage());
                            }
                        }
                    }
                    try{
                        stockService.processStockTechnicalIndicator(stockSymbol,key);

                    }
                    catch(HttpClientErrorException e){
                        e.printStackTrace();
                        for(int i=0; i<2; i++){
                            try{
                                Thread.sleep(10000);
                                stockService.processStockTechnicalIndicator(stockSymbol,key);
                            }
                            catch(HttpClientErrorException | InterruptedException e1){
                                log.error(e1.getMessage());
                            }
                        }
                    }
                    try{
                        stockService.processStockNewsSentiment(stockSymbol,key);
                    }
                    catch(HttpClientErrorException e){
                        e.printStackTrace();
                        for(int i=0; i<2; i++){
                            try{
                                Thread.sleep(10000);
                                stockService.processStockNewsSentiment(stockSymbol,key);
                            }
                            catch(HttpClientErrorException | InterruptedException e1){
                                log.error(e1.getMessage());
                            }
                        }
                    }
                }


                long lEndTime = System.currentTimeMillis();
                long elapsed = lEndTime - lStartTime;

                if(elapsed>45000){

                }
                else{
                    try {
                        Thread.sleep(45000-elapsed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            };
            executorService.submit(r);

        }
        executorService.shutdown();
        try{
            executorService.awaitTermination(400, TimeUnit.MINUTES);
        }
        catch(java.lang.InterruptedException e){
            e.printStackTrace();
        }



    }
}
