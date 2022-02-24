package my.learning;

import lombok.Data;


public class Stock {

	private String companyName;
	private double value;
	
	public Stock(String companyName, double value) {
		this.companyName = companyName;
		this.value = value;
	}
	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	}
