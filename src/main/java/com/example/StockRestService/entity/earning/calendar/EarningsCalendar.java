package com.example.StockRestService.entity.earning.calendar;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EarningsCalendar{

	@JsonProperty("earnings")
	private List<EarningsItem> earnings;

	@JsonProperty("description")
	private String description;

	@JsonProperty("from")
	private String from;

	@JsonProperty("to")
	private String to;

	@JsonProperty("type")
	private String type;

	public void setEarnings(List<EarningsItem> earnings){
		this.earnings = earnings;
	}

	public List<EarningsItem> getEarnings(){
		return earnings;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setFrom(String from){
		this.from = from;
	}

	public String getFrom(){
		return from;
	}

	public void setTo(String to){
		this.to = to;
	}

	public String getTo(){
		return to;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"EarningsCalendar{" + 
			"earnings = '" + earnings + '\'' + 
			",description = '" + description + '\'' + 
			",from = '" + from + '\'' + 
			",to = '" + to + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}