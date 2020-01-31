package com.example.StockRestService.dao;

import com.example.StockRestService.common.Commons;
import com.example.StockRestService.entity.DailyCandle;
import com.example.StockRestService.entity.StockEntity;
import com.example.StockRestService.entity.StockPerformanceEntity;
import com.example.StockRestService.entity.StockStartEndPriceEntity;
import com.example.StockRestService.entity.earning.Earning;
import com.example.StockRestService.entity.earning.calendar.EarningsItem;
import com.example.StockRestService.entity.stockSummary.StockSummary;
import com.example.StockRestService.rowmapper.StockEntityRowMapper;
import com.example.StockRestService.rowmapper.StockPerformanceRowMapper;
import com.example.StockRestService.rowmapper.StockStartEndPriceEntityRowMapper;
import com.example.StockRestService.util.Helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@Slf4j
@Repository
public class StockDaoImpl implements IStockDao{

    @Autowired
    @Qualifier("selectStockInformation")
    private String selectStockInformation;

    @Autowired
    @Qualifier("selectStartEndPrice")
    private String selectStartEndPrice;

    @Autowired
    @Qualifier("selectStartEndAdjustedPrice")
    private String selectStartEndAdjustedPrice;

    @Autowired
    @Qualifier("selectStockPerformance")
    private String selectStockPerformance;

    @Autowired
    @Qualifier("insertStockSummary")
    private String insertStockSummary;

    @Autowired
    @Qualifier("insertStock")
    private String insertStock;

    private JdbcTemplate jdbcTemplate;

    private SimpleDateFormat mmmddyyyy = new SimpleDateFormat("MMM dd,yyyy");

    private static String EARANING_DATA= "EARNING_DATA";
    private static String TECHNICAL_INDICATOR= "TECHNICAL_INDICATOR";

    private static String INSERT_DAILY_CANDLE = "INSERT INTO `fde`.`daily_candle`(`stock_symbol`,`date`,`candle_str`)VALUES(?,?,?);";

    public StockDaoImpl(@Qualifier("fdeDataSource") DriverManagerDataSource datasource){
        jdbcTemplate=new JdbcTemplate(datasource);
    }
    private Map<String,StockEntity> stockEntityHashMap = new HashMap<>();

    @PostConstruct
    private void init(){

        List<StockEntity> stockList=this.jdbcTemplate.query(selectStockInformation,new StockEntityRowMapper());
        for(StockEntity entity: stockList){
            stockEntityHashMap.put(entity.getStockSymbol(),entity);
        }

    }

    @Override
    public List<StockEntity> getStocks() {
        return (List<StockEntity>) stockEntityHashMap.values();
    }

    @Override
    public List<StockStartEndPriceEntity> getStockStartEndPriceEntity(){
        List<StockStartEndPriceEntity> result= this.jdbcTemplate.query(selectStartEndPrice,new StockStartEndPriceEntityRowMapper());
        for(StockStartEndPriceEntity entity: result){
            entity.setStockEntity(stockEntityHashMap.get(entity.getStockSymbol()));
        }
        return result;
    }

    @Override
    public List<StockStartEndPriceEntity> getStockStartEndPriceAdjustedEntity(){
        List<StockStartEndPriceEntity> result= this.jdbcTemplate.query(selectStartEndAdjustedPrice,new StockStartEndPriceEntityRowMapper());
        for(StockStartEndPriceEntity entity: result){
            entity.setStockEntity(stockEntityHashMap.get(entity.getStockSymbol()));
        }
        return result;
    }
    @Override
    public StockPerformanceEntity getStockPerformance(String stock){
        String[] args = {stock,stock,stock,stock,stock};
        StockPerformanceEntity stockPerformanceEntity = this.jdbcTemplate.queryForObject(selectStockPerformance,args,new StockPerformanceRowMapper());
        return stockPerformanceEntity;
    }

    @Override
    public int inserSummary(StockSummary stockSummary) {
        PreparedStatementSetter preparedStatement = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,stockSummary.getData().getSymbol());
                try{
                    Double marketCap = Double.parseDouble(stockSummary.getData().getSummaryData().getMarketCap().getValue().replace(",",""));
                    preparedStatement.setDouble(2,marketCap);
                }
                catch (Exception e){
                    preparedStatement.setObject(2,null);
                }

                try{
                    Double d;
                    d = Double.parseDouble(stockSummary.getData().getSummaryData().getPERatio().getValue().toString());
                    preparedStatement.setDouble(3,d);

                }
                catch(Exception e){
                    preparedStatement.setObject(3,null);

                }
                try{
                    preparedStatement.setDouble(4,Double.parseDouble(stockSummary.getData().getSummaryData().getForwardPE1Yr().getValue()));
                }
                catch(Exception e){
                    preparedStatement.setObject(4,null);

                }
                try{
                    preparedStatement.setDouble(5,Double.parseDouble(stockSummary.getData().getSummaryData().getEarningsPerShare().getValue().replace("$","")));

                }
                catch(Exception e){
                    preparedStatement.setObject(5,null);
                }
                try{
                    preparedStatement.setDouble(6,Double.parseDouble(stockSummary.getData().getSummaryData().getAnnualizedDividend().getValue().replace("$","")));

                }
                catch(Exception e){
                    preparedStatement.setObject(6,null);

                }
                try{
                    Double yield = Double.parseDouble(stockSummary.getData().getSummaryData().getYield().getValue().replace("%",""));
                    preparedStatement.setDouble(7,yield);
                }
                catch(Exception e){
                    preparedStatement.setObject(7,null);
                }

                preparedStatement.setString(8,stockSummary.getData().getAssetClass());
                try {
                    preparedStatement.setDate(9, new java.sql.Date (mmmddyyyy.parse(stockSummary.getData().getSummaryData().getExDividendDate().getValue()).getTime()));
                } catch (ParseException e) {
                    preparedStatement.setDate(9,null);
                }

                try {
                    preparedStatement.setDate(10, new java.sql.Date (mmmddyyyy.parse(stockSummary.getData().getSummaryData().getDividendPaymentDate().getValue()).getTime()));
                } catch (ParseException e) {
                    preparedStatement.setDate(10,null);
                }

                preparedStatement.setDate(11, new java.sql.Date(new Date().getTime()));
            }
        };
        return jdbcTemplate.update(insertStockSummary,preparedStatement);
    }

    @Override
    public int insertStock(StockSummary stockSummary) {

        PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, stockSummary.getData().getSymbol());
                preparedStatement.setString(2,stockSummary.getData().getCompanyName());
                preparedStatement.setString(3, stockSummary.getData().getSummaryData().getSector().getValue());
                preparedStatement.setString(4, stockSummary.getData().getSummaryData().getIndustry().getValue());
            }
        };

        return jdbcTemplate.update(insertStock,preparedStatementSetter);
    }

    @Override
    public void insertDailyCandle(List<DailyCandle> dailyCandleList) {
        ObjectMapper objectMapper = new ObjectMapper();
        this.jdbcTemplate.batchUpdate(INSERT_DAILY_CANDLE, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1,dailyCandleList.get(i).getStockSymbol());
                preparedStatement.setDate(2, new java.sql.Date(dailyCandleList.get(i).getDate().getTime()));
                try {
                    preparedStatement.setString(3,objectMapper.writeValueAsString(dailyCandleList.get(i).getCandle()));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public int getBatchSize() {
                return dailyCandleList.size();
            }
        });
    }


    @Override
    public Date getLatestInsertDate(String stockSymbol) {

        //Date latestDate = jdbcTemplate.queryForObject("select max(date) as date from daily_candle where stock_symbol=?",Date.class);
        Date latestDate = jdbcTemplate.queryForObject("select max(date) as date from stock_reference_data",Date.class);

        return latestDate;
    }

    @Override
    public List<Earning> getExistingEarning(String stockSymbol) {

        List<Earning> earnings = new ArrayList<>();
        String earningData;
        Object [] args = { stockSymbol , EARANING_DATA};
        try{
            earningData =  jdbcTemplate.queryForObject("select data from stock_reference_data where stock_symbol=? and reference_type=?", args, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                earnings = new ArrayList<>(Arrays.asList(objectMapper.readValue(earningData, Earning[].class)));
            } catch (IOException e) {
                log.error("Error parsing earning data to Object");
                return earnings;
            }
            return earnings;
        }

        catch(EmptyResultDataAccessException e){
            return earnings;
        }
    }


    @Override
    public void insertStockReferenceData(String stockSymbol, String type, String data) {


        java.sql.Date currentDate = new java.sql.Date(new Date().getTime());
        if(type.equals(Commons.EARANING_DATA)){
            jdbcTemplate.update("REPLACE into stock_reference_data (stock_symbol, reference_type, data, date) values(?,?,?,?)",stockSymbol,Commons.EARANING_DATA, data, Helper.getDefaultDate());
        }
        else if(type.equals(Commons.TECHNICAL_INDICATOR)){
            jdbcTemplate.update("REPLACE into stock_reference_data (stock_symbol, reference_type, data, date) values(?,?,?,?)",stockSymbol,Commons.TECHNICAL_INDICATOR, data,currentDate);
        }
        else if(type.equals(Commons.NEWS_SENTIMENT)){
            jdbcTemplate.update("REPLACE into stock_reference_data (stock_symbol, reference_type, data, date) values(?,?,?,?)",stockSymbol,Commons.NEWS_SENTIMENT, data,currentDate);
        }
    }

    @Override
    public void insertEarningCalendar(List<EarningsItem> earningsItemList) {

    }


    @Override
    public void insertStockReferenceData(List<EarningsItem> earningsItemList) {
        jdbcTemplate.batchUpdate("REPLACE into stock_reference_data (stock_symbol, reference_type, data, date) values(?,?,?,?)", new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1,(earningsItemList.get(i).getCode().split(Pattern.quote("."))[0]));
                preparedStatement.setString(2,Commons.EARNING_CALENDAR_DATA);
                preparedStatement.setString(3,earningsItemList.get(i).getDate());
                preparedStatement.setDate(4,new java.sql.Date(Helper.get_yyyy_mm_dd(earningsItemList.get(i).getDate()).getTime()));
            }

            @Override
            public int getBatchSize() {
                return earningsItemList.size();
            }
        });
    }

/*

    @Override
    public void insertEarningCalendar(List<EarningsItem> earningsItemList) {

    }
*/

}
