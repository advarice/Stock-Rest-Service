package com.example.StockRestService.entity.stockSummary;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PERatio{

	@JsonProperty("label")
	private String label;

	@JsonProperty("value")
	private Object value;

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setValue(Object value){
		this.value = value;
	}

	public Object getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"PERatio{" + 
			"label = '" + label + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}