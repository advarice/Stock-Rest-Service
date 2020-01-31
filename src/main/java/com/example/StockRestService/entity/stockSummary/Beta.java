package com.example.StockRestService.entity.stockSummary;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Beta{

	@JsonProperty("label")
	private String label;

	@JsonProperty("value")
	private int value;

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Beta{" + 
			"label = '" + label + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}