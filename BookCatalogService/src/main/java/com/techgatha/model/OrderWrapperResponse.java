package com.techgatha.model;

import java.util.Arrays;
import java.util.List;

public class OrderWrapperResponse {

	private List<OrderWrapper> orders;
	private List<String> favbooks = Arrays.asList("b10","b11");
	
	public List<OrderWrapper> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderWrapper> orders) {
		this.orders = orders;
	}
	public List<String> getFavbooks() {
		return favbooks;
	}
	public void setFavbooks(List<String> favbooks) {
		this.favbooks = favbooks;
	}
	
}
