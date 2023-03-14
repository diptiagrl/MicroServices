package com.citi.ms;

import java.math.BigDecimal;

public class CurrencyValue {

	private int id;
	private String from;
	private String to;
	private BigDecimal multiple;
	private BigDecimal conversionValue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getMultiple() {
		return multiple;
	}
	public void setMultiple(BigDecimal multiple) {
		this.multiple = multiple;
	}
	public BigDecimal getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}
	@Override
	public String toString() {
		return "CurrencyValue [id=" + id + ", from=" + from + ", to=" + to + ", multiple=" + multiple
				+ ", conversionValue=" + conversionValue + "]";
	}
	
	
}
