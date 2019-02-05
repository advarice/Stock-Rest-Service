package com.example.StockRestService.Dao;

import com.example.StockRestService.entity.StockEntity;
import com.example.StockRestService.rowmapper.StockEntityRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StockDaoImpl implements IStockDao{

    @Autowired
    @Qualifier("selectStockInformation")
    private String selectStockInformation;

    private JdbcTemplate jdbcTemplate;

    public StockDaoImpl(DriverManagerDataSource datasource){
        jdbcTemplate=new JdbcTemplate(datasource);
    }
    private List<StockEntity> stockEntityList = new ArrayList<>();

    @PostConstruct
    private void init(){
        stockEntityList=this.jdbcTemplate.query(selectStockInformation,new StockEntityRowMapper());
        //System.out.println(stockEntityList);
        //System.out.println(stockEntityList.size());
    }

    @Override
    public List<Object> getStocks() {
        return null;
    }
}
