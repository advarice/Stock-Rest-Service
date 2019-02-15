package com.example.StockRestService.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NewsArticles {

    @JsonProperty("articles")
    private List<NewsArticle> articles;

    public List<NewsArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsArticle> articles) {
        this.articles = articles;
    }
}
