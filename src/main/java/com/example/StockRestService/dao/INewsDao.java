package com.example.StockRestService.dao;

import com.example.StockRestService.entity.NewsArticle;

import java.util.List;

public interface INewsDao {
    public List<NewsArticle> getNews(String searchString);
}
