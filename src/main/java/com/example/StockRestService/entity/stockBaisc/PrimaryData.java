package com.example.StockRestService.entity.stockBaisc;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PrimaryData{

	@JsonProperty("netChange")
	private String netChange;

	@JsonProperty("percentageChange")
	private String percentageChange;

	@JsonProperty("isRealTime")
	private boolean isRealTime;

	@JsonProperty("deltaIndicator")
	private String deltaIndicator;

	@JsonProperty("lastTradeTimestamp")
	private String lastTradeTimestamp;

	@JsonProperty("lastSalePrice")
	private String lastSalePrice;

	public void setNetChange(String netChange){
		this.netChange = netChange;
	}

	public String getNetChange(){
		return netChange;
	}

	public void setPercentageChange(String percentageChange){
		this.percentageChange = percentageChange;
	}

	public String getPercentageChange(){
		return percentageChange;
	}

	public void setIsRealTime(boolean isRealTime){
		this.isRealTime = isRealTime;
	}

	public boolean isIsRealTime(){
		return isRealTime;
	}

	public void setDeltaIndicator(String deltaIndicator){
		this.deltaIndicator = deltaIndicator;
	}

	public String getDeltaIndicator(){
		return deltaIndicator;
	}

	public void setLastTradeTimestamp(String lastTradeTimestamp){
		this.lastTradeTimestamp = lastTradeTimestamp;
	}

	public String getLastTradeTimestamp(){
		return lastTradeTimestamp;
	}

	public void setLastSalePrice(String lastSalePrice){
		this.lastSalePrice = lastSalePrice;
	}

	public String getLastSalePrice(){
		return lastSalePrice;
	}

	@Override
 	public String toString(){
		return 
			"PrimaryData{" + 
			"netChange = '" + netChange + '\'' + 
			",percentageChange = '" + percentageChange + '\'' + 
			",isRealTime = '" + isRealTime + '\'' + 
			",deltaIndicator = '" + deltaIndicator + '\'' + 
			",lastTradeTimestamp = '" + lastTradeTimestamp + '\'' + 
			",lastSalePrice = '" + lastSalePrice + '\'' + 
			"}";
		}
}