package com.example.StockRestService.entity.earning.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EarningCalendar{

	@JsonProperty("earningsCalendar")
	private EarningsCalendar earningsCalendar;

	public void setEarningsCalendar(EarningsCalendar earningsCalendar){
		this.earningsCalendar = earningsCalendar;
	}

	public EarningsCalendar getEarningsCalendar(){
		return earningsCalendar;
	}

	@Override
 	public String toString(){
		return 
			"EarningCalendar{" + 
			"earningsCalendar = '" + earningsCalendar + '\'' + 
			"}";
		}
}