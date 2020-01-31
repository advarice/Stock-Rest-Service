package com.example.StockRestService.entity.stockSummary;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class StockSummary{

	@JsonProperty("data")
	private Data data;

	@JsonProperty("message")
	private Object message;

	@JsonProperty("status")
	private Status status;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setMessage(Object message){
		this.message = message;
	}

	public Object getMessage(){
		return message;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"StockSummary{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}