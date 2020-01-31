package com.example.StockRestService.entity.technical;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Trend{

	@JsonProperty("trending")
	private boolean trending;

	@JsonProperty("adx")
	private double adx;

	public void setTrending(boolean trending){
		this.trending = trending;
	}

	public boolean isTrending(){
		return trending;
	}

	public void setAdx(double adx){
		this.adx = adx;
	}

	public double getAdx(){
		return adx;
	}

	@Override
 	public String toString(){
		return 
			"Trend{" + 
			"trending = '" + trending + '\'' + 
			",adx = '" + adx + '\'' + 
			"}";
		}
}