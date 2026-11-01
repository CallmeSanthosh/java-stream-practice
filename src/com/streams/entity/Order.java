package com.streams.entity;

import java.util.List;

public class Order {
	String orderId;
	String customerName;
	List<String> items;
	double totalAmount;
	String status;

	public Order(String orderId, String customerName, List<String> items, double totalAmount, String status) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.items = items;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public List<String> getItems() {
		return items;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return orderId + " - " + customerName + " ($" + totalAmount + ", " + status + ")";
	}
}
