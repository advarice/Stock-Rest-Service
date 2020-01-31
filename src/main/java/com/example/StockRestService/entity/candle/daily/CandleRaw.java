package com.example.StockRestService.entity.candle.daily;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CandleRaw {

	@JsonProperty("c")
	private List<Double> C;

	@JsonProperty("s")
	private String S;

	@JsonProperty("t")
	private List<Long> T;

	@JsonProperty("v")
	private List<Long> V;

	@JsonProperty("h")
	private List<Double> H;

	@JsonProperty("l")
	private List<Double> L;

	@JsonProperty("o")
	private List<Double> O;

	public void setC(List<Double> C){
		this.C = C;
	}

	public List<Double> getC(){
		return C;
	}

	public void setS(String S){
		this.S = S;
	}

	public String getS(){
		return S;
	}

	public void setT(List<Long> T){
		this.T = T;
	}

	public List<Long> getT(){
		return T;
	}

	public void setV(List<Long> V){
		this.V = V;
	}

	public List<Long> getV(){
		return V;
	}

	public void setH(List<Double> H){
		this.H = H;
	}

	public List<Double> getH(){
		return H;
	}

	public void setL(List<Double> L){
		this.L = L;
	}

	public List<Double> getL(){
		return L;
	}

	public void setO(List<Double> O){
		this.O = O;
	}

	public List<Double> getO(){
		return O;
	}

	@Override
 	public String toString(){
		return 
			"CandleRaw{" +
			"c = '" + C + '\'' + 
			",s = '" + S + '\'' + 
			",t = '" + T + '\'' + 
			",v = '" + V + '\'' + 
			",h = '" + H + '\'' + 
			",l = '" + L + '\'' + 
			",o = '" + O + '\'' + 
			"}";
		}
}