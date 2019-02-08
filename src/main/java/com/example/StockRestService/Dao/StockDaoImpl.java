package com.example.StockRestService.Dao;

import com.example.StockRestService.entity.StockEntity;
import com.example.StockRestService.entity.StockStartEndPriceEntity;
import com.example.StockRestService.rowmapper.StockEntityRowMapper;
import com.example.StockRestService.rowmapper.StockStartEndPriceEntityRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

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

    private JdbcTemplate jdbcTemplate;

    public StockDaoImpl(DriverManagerDataSource datasource){
        jdbcTemplate=new JdbcTemplate(datasource);
    }
    private Map<String,StockEntity> stockEntityHashMap = new HashMap<>();

    @PostConstruct
    private void init(){

        List<StockEntity> stockList=this.jdbcTemplate.query(selectStockInformation,new StockEntityRowMapper());
        for(StockEntity entity: stockList){
            stockEntityHashMap.put(entity.getStockSymbol(),entity);
        }
        //System.out.println(stockEntityList);
        //System.out.println(stockEntityList.size());
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

}
