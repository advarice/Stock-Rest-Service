package com.example.StockRestService.controller;

import com.example.StockRestService.dao.IMacroDao;
import com.example.StockRestService.entity.test.TestObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class MacroController
{

    @Qualifier("selectStockInformation")
    @Autowired
    private String s;

    @Autowired
    private IMacroDao dao;


    @RequestMapping(value = "/testMacro", method = RequestMethod.GET)
    public List<Map<Object,Object>>  test(){


        return dao.getCountryGDP();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public TestObject  test1(){

        TestObject testObject = new TestObject();

        testObject.setTimestamp(new Timestamp((new Date()).getTime()));
        testObject.setDate(new Date());
        ObjectMapper objectMapper = new ObjectMapper();

        return testObject;
    }



}
