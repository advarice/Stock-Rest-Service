package com.example.StockRestService.Dao;

import com.example.StockRestService.entity.NewsArticle;

import java.util.List;

public interface INewsDao {
    public List<NewsArticle> getNews(String searchString);
}
