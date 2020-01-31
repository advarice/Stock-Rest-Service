package com.example.StockRestService.entity.technical;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Count{

	@JsonProperty("buy")
	private int buy;

	@JsonProperty("sell")
	private int sell;

	@JsonProperty("neutral")
	private int neutral;

	public void setBuy(int buy){
		this.buy = buy;
	}

	public int getBuy(){
		return buy;
	}

	public void setSell(int sell){
		this.sell = sell;
	}

	public int getSell(){
		return sell;
	}

	public void setNeutral(int neutral){
		this.neutral = neutral;
	}

	public int getNeutral(){
		return neutral;
	}

	@Override
 	public String toString(){
		return 
			"Count{" + 
			"buy = '" + buy + '\'' + 
			",sell = '" + sell + '\'' + 
			",neutral = '" + neutral + '\'' + 
			"}";
		}
}