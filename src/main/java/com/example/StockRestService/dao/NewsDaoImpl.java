package com.example.StockRestService.dao;

import com.example.StockRestService.entity.NewsArticle;
import com.example.StockRestService.entity.NewsArticles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class NewsDaoImpl implements INewsDao{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${news.api.key}")
    private String apiKey;

    @Override
    public List<NewsArticle> getNews(String searchString) {

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String d=dtf.format(LocalDate.now().minusDays(30));
        return restTemplate.getForObject("https://newsapi.org/v2/everything?q="+searchString +"&from="+d+"&sortBy=popularity&apiKey="+apiKey, NewsArticles.class).getArticles();
    }
}