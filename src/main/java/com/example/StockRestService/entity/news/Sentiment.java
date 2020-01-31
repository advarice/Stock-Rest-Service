package com.example.StockRestService.entity.news;

public class Sentiment{
	private int bearishPercent;
	private int bullishPercent;

	public void setBearishPercent(int bearishPercent){
		this.bearishPercent = bearishPercent;
	}

	public int getBearishPercent(){
		return bearishPercent;
	}

	public void setBullishPercent(int bullishPercent){
		this.bullishPercent = bullishPercent;
	}

	public int getBullishPercent(){
		return bullishPercent;
	}

	@Override
 	public String toString(){
		return 
			"Sentiment{" + 
			"bearishPercent = '" + bearishPercent + '\'' + 
			",bullishPercent = '" + bullishPercent + '\'' + 
			"}";
		}
}
