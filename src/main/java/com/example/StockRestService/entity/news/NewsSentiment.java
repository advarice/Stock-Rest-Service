package com.example.StockRestService.entity.news;

public class NewsSentiment{
	private Sentiment sentiment;
	private String symbol;
	private double sectorAverageBullishPercent;
	private double sectorAverageNewsScore;
	private Buzz buzz;
	private double companyNewsScore;

	public void setSentiment(Sentiment sentiment){
		this.sentiment = sentiment;
	}

	public Sentiment getSentiment(){
		return sentiment;
	}

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public void setSectorAverageBullishPercent(double sectorAverageBullishPercent){
		this.sectorAverageBullishPercent = sectorAverageBullishPercent;
	}

	public double getSectorAverageBullishPercent(){
		return sectorAverageBullishPercent;
	}

	public void setSectorAverageNewsScore(double sectorAverageNewsScore){
		this.sectorAverageNewsScore = sectorAverageNewsScore;
	}

	public double getSectorAverageNewsScore(){
		return sectorAverageNewsScore;
	}

	public void setBuzz(Buzz buzz){
		this.buzz = buzz;
	}

	public Buzz getBuzz(){
		return buzz;
	}

	public void setCompanyNewsScore(double companyNewsScore){
		this.companyNewsScore = companyNewsScore;
	}

	public double getCompanyNewsScore(){
		return companyNewsScore;
	}

	@Override
 	public String toString(){
		return 
			"NewsSentiment{" + 
			"sentiment = '" + sentiment + '\'' + 
			",symbol = '" + symbol + '\'' + 
			",sectorAverageBullishPercent = '" + sectorAverageBullishPercent + '\'' + 
			",sectorAverageNewsScore = '" + sectorAverageNewsScore + '\'' + 
			",buzz = '" + buzz + '\'' + 
			",companyNewsScore = '" + companyNewsScore + '\'' + 
			"}";
		}
}
