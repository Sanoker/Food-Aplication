package com.foodapp.model;

public class Orders {
	private int ordersID;
	private int userID;
	private int restaurantID;
	private double totalAmount;
	private String status;
	private String paymentMode;
	public int getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(int ordersID) {
		this.ordersID = ordersID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double d) {
		this.totalAmount = d;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMethod() {
		return paymentMode;
	}
	public void setPaymentMethod(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Orders() {
		super();
	}
	public Orders(int ordersID, int userID, int restaurantID, double totalAmount, String status,
			String paymentMode) {
		this.ordersID = ordersID;
		this.userID = userID;
		this.restaurantID = restaurantID;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	@Override
	public String toString() {
		return ordersID + "  " + userID + "  " + restaurantID
				+ "  " + totalAmount + "  " + status + "  " + paymentMode;
	}
}
