package com.example.StockRestService.entity.technical;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class TechnicalIndicator{

	@JsonProperty("trend")
	private Trend trend;

	@JsonProperty("technicalAnalysis")
	private TechnicalAnalysis technicalAnalysis;

	public void setTrend(Trend trend){
		this.trend = trend;
	}

	public Trend getTrend(){
		return trend;
	}

	public void setTechnicalAnalysis(TechnicalAnalysis technicalAnalysis){
		this.technicalAnalysis = technicalAnalysis;
	}

	public TechnicalAnalysis getTechnicalAnalysis(){
		return technicalAnalysis;
	}

	@Override
 	public String toString(){
		return 
			"TechnicalIndicator{" + 
			"trend = '" + trend + '\'' + 
			",technicalAnalysis = '" + technicalAnalysis + '\'' + 
			"}";
		}
}