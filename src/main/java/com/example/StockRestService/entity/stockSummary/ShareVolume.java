package com.example.StockRestService.entity.stockSummary;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ShareVolume{

	@JsonProperty("label")
	private String label;

	@JsonProperty("value")
	private String value;

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"ShareVolume{" + 
			"label = '" + label + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}