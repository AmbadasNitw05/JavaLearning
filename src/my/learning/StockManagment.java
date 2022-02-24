package my.learning;

import java.util.List;

public class StockManagment {

	private List<Stock> stocks;
	
	public StockManagment(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public String getStatus() {
		
		if(stocks == null) return "BAD";
		
		double sum = 0;
		
		for(Stock stock: this.stocks) {
			sum += stock.getValue();
		}
		
		if(sum > 1000)
			return "GOOD";
		if(sum > 500)
			return "OK";
		else
			return "BAD";
	}
	
	
	
}
