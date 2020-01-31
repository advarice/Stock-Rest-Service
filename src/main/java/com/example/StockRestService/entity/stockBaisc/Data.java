package com.example.StockRestService.entity.stockBaisc;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@JsonProperty("isNasdaq100")
	private boolean isNasdaq100;

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("stockType")
	private String stockType;

	@JsonProperty("companyName")
	private String companyName;

	@JsonProperty("complianceStatus")
	private String complianceStatus;

	@JsonProperty("assetClass")
	private String assetClass;

	@JsonProperty("isNasdaqListed")
	private boolean isNasdaqListed;

	@JsonProperty("primaryData")
	private PrimaryData primaryData;

	@JsonProperty("keyStats")
	private KeyStats keyStats;

	@JsonProperty("secondaryData")
	private Object secondaryData;

	@JsonProperty("marketStatus")
	private String marketStatus;

	@JsonProperty("exchange")
	private String exchange;

	@JsonProperty("isHeld")
	private boolean isHeld;

	public void setIsNasdaq100(boolean isNasdaq100){
		this.isNasdaq100 = isNasdaq100;
	}

	public boolean isIsNasdaq100(){
		return isNasdaq100;
	}

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public void setStockType(String stockType){
		this.stockType = stockType;
	}

	public String getStockType(){
		return stockType;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setComplianceStatus(String complianceStatus){
		this.complianceStatus = complianceStatus;
	}

	public String getComplianceStatus(){
		return complianceStatus;
	}

	public void setAssetClass(String assetClass){
		this.assetClass = assetClass;
	}

	public String getAssetClass(){
		return assetClass;
	}

	public void setIsNasdaqListed(boolean isNasdaqListed){
		this.isNasdaqListed = isNasdaqListed;
	}

	public boolean isIsNasdaqListed(){
		return isNasdaqListed;
	}

	public void setPrimaryData(PrimaryData primaryData){
		this.primaryData = primaryData;
	}

	public PrimaryData getPrimaryData(){
		return primaryData;
	}

	public void setKeyStats(KeyStats keyStats){
		this.keyStats = keyStats;
	}

	public KeyStats getKeyStats(){
		return keyStats;
	}

	public void setSecondaryData(Object secondaryData){
		this.secondaryData = secondaryData;
	}

	public Object getSecondaryData(){
		return secondaryData;
	}

	public void setMarketStatus(String marketStatus){
		this.marketStatus = marketStatus;
	}

	public String getMarketStatus(){
		return marketStatus;
	}

	public void setExchange(String exchange){
		this.exchange = exchange;
	}

	public String getExchange(){
		return exchange;
	}

	public void setIsHeld(boolean isHeld){
		this.isHeld = isHeld;
	}

	public boolean isIsHeld(){
		return isHeld;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"isNasdaq100 = '" + isNasdaq100 + '\'' + 
			",symbol = '" + symbol + '\'' + 
			",stockType = '" + stockType + '\'' + 
			",companyName = '" + companyName + '\'' + 
			",complianceStatus = '" + complianceStatus + '\'' + 
			",assetClass = '" + assetClass + '\'' + 
			",isNasdaqListed = '" + isNasdaqListed + '\'' + 
			",primaryData = '" + primaryData + '\'' + 
			",keyStats = '" + keyStats + '\'' + 
			",secondaryData = '" + secondaryData + '\'' + 
			",marketStatus = '" + marketStatus + '\'' + 
			",exchange = '" + exchange + '\'' + 
			",isHeld = '" + isHeld + '\'' + 
			"}";
		}
}