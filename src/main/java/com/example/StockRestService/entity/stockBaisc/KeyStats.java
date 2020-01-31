package com.example.StockRestService.entity.stockBaisc;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class KeyStats{

	@JsonProperty("Volume")
	private Volume volume;

	@JsonProperty("OpenPrice")
	private OpenPrice openPrice;

	@JsonProperty("PreviousClose")
	private PreviousClose previousClose;

	@JsonProperty("MarketCap")
	private MarketCap marketCap;

	public void setVolume(Volume volume){
		this.volume = volume;
	}

	public Volume getVolume(){
		return volume;
	}

	public void setOpenPrice(OpenPrice openPrice){
		this.openPrice = openPrice;
	}

	public OpenPrice getOpenPrice(){
		return openPrice;
	}

	public void setPreviousClose(PreviousClose previousClose){
		this.previousClose = previousClose;
	}

	public PreviousClose getPreviousClose(){
		return previousClose;
	}

	public void setMarketCap(MarketCap marketCap){
		this.marketCap = marketCap;
	}

	public MarketCap getMarketCap(){
		return marketCap;
	}

	@Override
 	public String toString(){
		return 
			"KeyStats{" + 
			"volume = '" + volume + '\'' + 
			",openPrice = '" + openPrice + '\'' + 
			",previousClose = '" + previousClose + '\'' + 
			",marketCap = '" + marketCap + '\'' + 
			"}";
		}
}