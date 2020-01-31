package com.example.StockRestService.entity.technical;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class TechnicalAnalysis{

	@JsonProperty("count")
	private Count count;

	@JsonProperty("signal")
	private String signal;

	public void setCount(Count count){
		this.count = count;
	}

	public Count getCount(){
		return count;
	}

	public void setSignal(String signal){
		this.signal = signal;
	}

	public String getSignal(){
		return signal;
	}

	@Override
 	public String toString(){
		return 
			"TechnicalAnalysis{" + 
			"count = '" + count + '\'' + 
			",signal = '" + signal + '\'' + 
			"}";
		}
}