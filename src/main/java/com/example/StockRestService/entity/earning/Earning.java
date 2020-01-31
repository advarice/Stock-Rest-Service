package com.example.StockRestService.entity.earning;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.util.Date;
import java.util.Objects;

@Generated("com.robohorse.robopojogenerator")
public class Earning{

	@JsonProperty("actual")
	private double actual;

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("period")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date period;

	@JsonProperty("estimate")
	private double estimate;

	public void setActual(double actual){
		this.actual = actual;
	}

	public double getActual(){
		return actual;
	}

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public void setPeriod(Date period){
		this.period = period;
	}


	public Date getPeriod(){
		return period;
	}

	public void setEstimate(double estimate){
		this.estimate = estimate;
	}

	public double getEstimate(){
		return estimate;
	}

	@Override
 	public String toString(){
		return 
			"Earning{" + 
			"actual = '" + actual + '\'' + 
			",symbol = '" + symbol + '\'' + 
			",period = '" + period + '\'' + 
			",estimate = '" + estimate + '\'' + 
			"}";

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Earning earning = (Earning) o;
		return Double.compare(earning.getActual(), getActual()) == 0 &&
				Double.compare(earning.getEstimate(), getEstimate()) == 0 &&
				getSymbol().equals(earning.getSymbol()) &&
				getPeriod().equals(earning.getPeriod());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getActual(), getSymbol(), getPeriod(), getEstimate());
	}
}