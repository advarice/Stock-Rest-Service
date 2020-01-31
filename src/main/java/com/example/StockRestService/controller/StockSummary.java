package com.example.StockRestService.controller;

import com.example.StockRestService.dao.IGenericDao;
import com.example.StockRestService.dao.IStockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/summary")
public class StockSummary {

    @Autowired
    private IGenericDao genericDao;

    @Autowired
    private IStockDao stockDao;



    @RequestMapping(value = "/stock", method = RequestMethod.GET)
    public List<Map<String, Object>> getStockSummary(@RequestParam("stockSymbol") String stockSymbol){

        List<Map<String, Object>> referenceData = genericDao.getListMap("select * from stock_reference_data where stock_symbol=?", stockSymbol);
        List<Map<String, Object>> candles = genericDao.getListMap("select * from daily_candle where stock_symbol=?", stockSymbol);
        Map<String, Object> candlesData = new HashMap<>();
        candlesData.put("candleData", candles);

        referenceData.add(candlesData);
        return referenceData;
    }


}
