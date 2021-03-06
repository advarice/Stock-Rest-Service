package com.example.StockRestService.controller;

import com.example.StockRestService.config.SqlConfig;
import com.example.StockRestService.dao.INewsDao;
import com.example.StockRestService.entity.NewsArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NewsController {


    @Autowired
    private INewsDao newsDao;


    @Autowired
    private SqlConfig sqlConfig;


    @RequestMapping(value="/testNews/{stockId}",method= RequestMethod.GET)
    public List<NewsArticle> daoTest3(@PathVariable String stockId){
        List<NewsArticle> newsArticles= newsDao.getNews(stockId);
        if (newsArticles.size()<3){
            return newsArticles;
        }
        return newsDao.getNews(stockId).subList(0,2);
    }
}
