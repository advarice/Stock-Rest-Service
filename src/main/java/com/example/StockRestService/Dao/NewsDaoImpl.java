package com.example.StockRestService.Dao;

import com.example.StockRestService.entity.NewsArticle;
import com.example.StockRestService.entity.NewsArticles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Repository
public class NewsDaoImpl implements INewsDao{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${news.api.key}")
    private String apiKey;

    @Override
    public List<NewsArticle> getNews(String searchString) {

/*        ResponseEntity<List<NewsArticle>> articlesResponse= restTemplate.exchange(
                "https://newsapi.org/v2/everything?q=bitcoin&from=2019-02-13&sortBy=popularity&apiKey=59c4e7dffaed474b99a021543dea9d17"
                , HttpMethod.GET
                ,null,new ParameterizedTypeReference<List<NewsArticle>>(){});
        System.out.println(articlesResponse.getBody());
        return articlesResponse.getBody();*/
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String d=dtf.format(LocalDate.now().minusDays(30));
        return restTemplate.getForObject("https://newsapi.org/v2/everything?q="+searchString +"&from="+d+"&sortBy=popularity&apiKey="+apiKey, NewsArticles.class).getArticles();
    }
}
