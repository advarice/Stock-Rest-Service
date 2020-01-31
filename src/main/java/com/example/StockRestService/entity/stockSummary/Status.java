package com.example.StockRestService.entity.stockSummary;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Status{

	@JsonProperty("bCodeMessage")
	private Object bCodeMessage;

	@JsonProperty("developerMessage")
	private Object developerMessage;

	@JsonProperty("rCode")
	private int rCode;

	public void setBCodeMessage(Object bCodeMessage){
		this.bCodeMessage = bCodeMessage;
	}

	public Object getBCodeMessage(){
		return bCodeMessage;
	}

	public void setDeveloperMessage(Object developerMessage){
		this.developerMessage = developerMessage;
	}

	public Object getDeveloperMessage(){
		return developerMessage;
	}

	public void setRCode(int rCode){
		this.rCode = rCode;
	}

	public int getRCode(){
		return rCode;
	}

	@Override
 	public String toString(){
		return 
			"Status{" + 
			"bCodeMessage = '" + bCodeMessage + '\'' + 
			",developerMessage = '" + developerMessage + '\'' + 
			",rCode = '" + rCode + '\'' + 
			"}";
		}
}