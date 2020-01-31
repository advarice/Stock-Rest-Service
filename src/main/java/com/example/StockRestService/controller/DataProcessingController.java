package com.example.StockRestService.controller;

import com.example.StockRestService.scheduler.StockProcessingScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataProcess")
public class DataProcessingController {

    @Autowired
    private StockProcessingScheduler processingScheduler;

    @RequestMapping(value = "/daily", method = RequestMethod.GET)
    public void dailyProcess(){

        processingScheduler.processDailyStock();

    }

    @RequestMapping("/reprocess/ind")
    public void processTechInd(){
        processingScheduler.processMissingIndicator();
    }

    @RequestMapping("/reprocess/news")
    public void processNews(){
        processingScheduler.processMissing();
    }


}
