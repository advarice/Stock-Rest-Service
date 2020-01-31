package com.example.StockRestService.entity.stockSummary;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("companyName")
	private String companyName;

	@JsonProperty("assetClass")
	private String assetClass;

	@JsonProperty("summaryData")
	private SummaryData summaryData;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public void setAssetClass(String assetClass){
		this.assetClass = assetClass;
	}

	public String getAssetClass(){
		return assetClass;
	}

	public void setSummaryData(SummaryData summaryData){
		this.summaryData = summaryData;
	}

	public SummaryData getSummaryData(){
		return summaryData;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"symbol = '" + symbol + '\'' +
			"companyName = '" + companyName + '\'' +
			",assetClass = '" + assetClass + '\'' +
			",summaryData = '" + summaryData + '\'' + 
			"}";
		}
}