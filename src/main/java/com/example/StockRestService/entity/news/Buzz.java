package com.example.StockRestService.entity.news;

public class Buzz{
	private double weeklyAverage;
	private int articlesInLastWeek;
	private double buzz;

	public void setWeeklyAverage(double weeklyAverage){
		this.weeklyAverage = weeklyAverage;
	}

	public double getWeeklyAverage(){
		return weeklyAverage;
	}

	public void setArticlesInLastWeek(int articlesInLastWeek){
		this.articlesInLastWeek = articlesInLastWeek;
	}

	public int getArticlesInLastWeek(){
		return articlesInLastWeek;
	}

	public void setBuzz(double buzz){
		this.buzz = buzz;
	}

	public double getBuzz(){
		return buzz;
	}

	@Override
 	public String toString(){
		return 
			"Buzz{" + 
			"weeklyAverage = '" + weeklyAverage + '\'' + 
			",articlesInLastWeek = '" + articlesInLastWeek + '\'' + 
			",buzz = '" + buzz + '\'' + 
			"}";
		}
}
