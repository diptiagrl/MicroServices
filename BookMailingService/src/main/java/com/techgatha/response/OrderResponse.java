package com.techgatha.response;

import java.util.Arrays;
import java.util.List;

import com.techgatha.model.BookOrder;

public class OrderResponse {

	private List<BookOrder> orders;
	private List<String> favbooks = Arrays.asList("b10","b11");
	
	public List<BookOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<BookOrder> orders) {
		this.orders = orders;
	}
	public List<String> getFavbooks() {
		return favbooks;
	}
	public void setFavbooks(List<String> favbooks) {
		this.favbooks = favbooks;
	}
	
	
}
