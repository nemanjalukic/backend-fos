package com.nl.fos.vo.request;

import com.nl.fos.model.FoodItem;

public class OrderItemsRequest {
	
	public  int quantity;
	public FoodItem foodItem;
	
	public OrderItemsRequest(int quantity, FoodItem foodItem) {
		super();
		this.quantity = quantity;
		this.foodItem = foodItem;
	}
	public OrderItemsRequest() {
		super();
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public FoodItem getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}
	
	
	

}
