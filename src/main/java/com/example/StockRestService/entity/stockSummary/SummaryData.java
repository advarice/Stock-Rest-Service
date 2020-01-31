package com.example.StockRestService.entity.stockSummary;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SummaryData{

	@JsonProperty("OneYrTarget")
	private OneYrTarget oneYrTarget;

	@JsonProperty("EarningsPerShare")
	private EarningsPerShare earningsPerShare;

	@JsonProperty("Sector")
	private Sector sector;

	@JsonProperty("FiftTwoWeekHighLow")
	private FiftTwoWeekHighLow fiftTwoWeekHighLow;

	@JsonProperty("ShareVolume")
	private ShareVolume shareVolume;

	@JsonProperty("ExDividendDate")
	private ExDividendDate exDividendDate;

	@JsonProperty("PreviousClose")
	private PreviousClose previousClose;

	@JsonProperty("Beta")
	private Beta beta;

	@JsonProperty("Exchange")
	private Exchange exchange;

	@JsonProperty("Industry")
	private Industry industry;

	@JsonProperty("AnnualizedDividend")
	private AnnualizedDividend annualizedDividend;

	@JsonProperty("PERatio")
	private PERatio pERatio;

	@JsonProperty("DividendPaymentDate")
	private DividendPaymentDate dividendPaymentDate;

	@JsonProperty("AverageVolume")
	private AverageVolume averageVolume;

	@JsonProperty("ForwardPE1Yr")
	private ForwardPE1Yr forwardPE1Yr;

	@JsonProperty("TodayHighLow")
	private TodayHighLow todayHighLow;

	@JsonProperty("Yield")
	private Yield yield;

	@JsonProperty("MarketCap")
	private MarketCap marketCap;

	public void setOneYrTarget(OneYrTarget oneYrTarget){
		this.oneYrTarget = oneYrTarget;
	}

	public OneYrTarget getOneYrTarget(){
		return oneYrTarget;
	}

	public void setEarningsPerShare(EarningsPerShare earningsPerShare){
		this.earningsPerShare = earningsPerShare;
	}

	public EarningsPerShare getEarningsPerShare(){
		return earningsPerShare;
	}

	public void setSector(Sector sector){
		this.sector = sector;
	}

	public Sector getSector(){
		return sector;
	}

	public void setFiftTwoWeekHighLow(FiftTwoWeekHighLow fiftTwoWeekHighLow){
		this.fiftTwoWeekHighLow = fiftTwoWeekHighLow;
	}

	public FiftTwoWeekHighLow getFiftTwoWeekHighLow(){
		return fiftTwoWeekHighLow;
	}

	public void setShareVolume(ShareVolume shareVolume){
		this.shareVolume = shareVolume;
	}

	public ShareVolume getShareVolume(){
		return shareVolume;
	}

	public void setExDividendDate(ExDividendDate exDividendDate){
		this.exDividendDate = exDividendDate;
	}

	public ExDividendDate getExDividendDate(){
		return exDividendDate;
	}

	public void setPreviousClose(PreviousClose previousClose){
		this.previousClose = previousClose;
	}

	public PreviousClose getPreviousClose(){
		return previousClose;
	}

	public void setBeta(Beta beta){
		this.beta = beta;
	}

	public Beta getBeta(){
		return beta;
	}

	public void setExchange(Exchange exchange){
		this.exchange = exchange;
	}

	public Exchange getExchange(){
		return exchange;
	}

	public void setIndustry(Industry industry){
		this.industry = industry;
	}

	public Industry getIndustry(){
		return industry;
	}

	public void setAnnualizedDividend(AnnualizedDividend annualizedDividend){
		this.annualizedDividend = annualizedDividend;
	}

	public AnnualizedDividend getAnnualizedDividend(){
		return annualizedDividend;
	}

	public void setPERatio(PERatio pERatio){
		this.pERatio = pERatio;
	}

	public PERatio getPERatio(){
		return pERatio;
	}

	public void setDividendPaymentDate(DividendPaymentDate dividendPaymentDate){
		this.dividendPaymentDate = dividendPaymentDate;
	}

	public DividendPaymentDate getDividendPaymentDate(){
		return dividendPaymentDate;
	}

	public void setAverageVolume(AverageVolume averageVolume){
		this.averageVolume = averageVolume;
	}

	public AverageVolume getAverageVolume(){
		return averageVolume;
	}

	public void setForwardPE1Yr(ForwardPE1Yr forwardPE1Yr){
		this.forwardPE1Yr = forwardPE1Yr;
	}

	public ForwardPE1Yr getForwardPE1Yr(){
		return forwardPE1Yr;
	}

	public void setTodayHighLow(TodayHighLow todayHighLow){
		this.todayHighLow = todayHighLow;
	}

	public TodayHighLow getTodayHighLow(){
		return todayHighLow;
	}

	public void setYield(Yield yield){
		this.yield = yield;
	}

	public Yield getYield(){
		return yield;
	}

	public void setMarketCap(MarketCap marketCap){
		this.marketCap = marketCap;
	}

	public MarketCap getMarketCap(){
		return marketCap;
	}

	@Override
 	public String toString(){
		return 
			"SummaryData{" + 
			"oneYrTarget = '" + oneYrTarget + '\'' + 
			",earningsPerShare = '" + earningsPerShare + '\'' + 
			",sector = '" + sector + '\'' + 
			",fiftTwoWeekHighLow = '" + fiftTwoWeekHighLow + '\'' + 
			",shareVolume = '" + shareVolume + '\'' + 
			",exDividendDate = '" + exDividendDate + '\'' + 
			",previousClose = '" + previousClose + '\'' + 
			",beta = '" + beta + '\'' + 
			",exchange = '" + exchange + '\'' + 
			",industry = '" + industry + '\'' + 
			",annualizedDividend = '" + annualizedDividend + '\'' + 
			",pERatio = '" + pERatio + '\'' + 
			",dividendPaymentDate = '" + dividendPaymentDate + '\'' + 
			",averageVolume = '" + averageVolume + '\'' + 
			",forwardPE1Yr = '" + forwardPE1Yr + '\'' + 
			",todayHighLow = '" + todayHighLow + '\'' + 
			",yield = '" + yield + '\'' + 
			",marketCap = '" + marketCap + '\'' + 
			"}";
		}
}