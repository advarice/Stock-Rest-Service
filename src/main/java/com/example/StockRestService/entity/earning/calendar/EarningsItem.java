package com.example.StockRestService.entity.earning.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EarningsItem{

	@JsonProperty("date")
	private String date;

	@JsonProperty("actual")
	private Object actual;

	@JsonProperty("code")
	private String code;

	@JsonProperty("estimate")
	private Object estimate;

	@JsonProperty("difference")
	private int difference;

	@JsonProperty("percent")
	private Object percent;

	@JsonProperty("report_date")
	private String reportDate;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setActual(Object actual){
		this.actual = actual;
	}

	public Object getActual(){
		return actual;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setEstimate(Object estimate){
		this.estimate = estimate;
	}

	public Object getEstimate(){
		return estimate;
	}

	public void setDifference(int difference){
		this.difference = difference;
	}

	public int getDifference(){
		return difference;
	}

	public void setPercent(Object percent){
		this.percent = percent;
	}

	public Object getPercent(){
		return percent;
	}

	public void setReportDate(String reportDate){
		this.reportDate = reportDate;
	}

	public String getReportDate(){
		return reportDate;
	}

	@Override
 	public String toString(){
		return 
			"EarningsItem{" + 
			"date = '" + date + '\'' + 
			",actual = '" + actual + '\'' + 
			",code = '" + code + '\'' + 
			",estimate = '" + estimate + '\'' + 
			",difference = '" + difference + '\'' + 
			",percent = '" + percent + '\'' + 
			",report_date = '" + reportDate + '\'' + 
			"}";
		}
}