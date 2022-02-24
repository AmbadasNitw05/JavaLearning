package my.learning;

import java.util.Arrays;
import java.util.List;

public class UserManagement {

	private String customerId;
	
	public String getStatusOfStocks() {
		
		// Current stock values
		
		List<Stock> currentStocks = getCurrentStocksFake(customerId);
		
		StockManagment sMgmt = new StockManagment(currentStocks);
		return sMgmt.getStatus();
		
	}

	private List<Stock> getCurrentStocksFake(String customerId) {
		// TODO Auto-generated method stub
		return Arrays.asList(new Stock("ABC", 300.0), new Stock("XYZ", 400));
	}
}
