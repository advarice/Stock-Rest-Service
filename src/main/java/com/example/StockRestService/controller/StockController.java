package com.example.StockRestService.controller;

import com.example.StockRestService.Dao.IStockDao;
import com.example.StockRestService.entity.StockEntity;
import com.example.StockRestService.entity.StockStartEndPriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class StockController
{

    @Qualifier("selectStockInformation")
    @Autowired
    private String s;

    @Autowired
    private IStockDao dao;

    @RequestMapping("/test")
    public String test(){
        return s;
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
}
