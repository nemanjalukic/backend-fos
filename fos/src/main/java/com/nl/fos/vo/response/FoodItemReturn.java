package com.nl.fos.vo.response;

import com.nl.fos.model.FoodItem;

public class FoodItemReturn {
    private Long id;


    private String name;


    private String description;


    private Double price;


    private String picture;
    

    private String category;
    
    
    private String restaurant;
    
    


	public FoodItemReturn(FoodItem item) {
		super();
		this.id=item.getId();
		this.name=item.getName();
		this.description=item.getDescription();
		this.picture=item.getPicture();
		this.price=item.getPrice();
		this.category=item.getCategory().getCategory();
		this.restaurant=item.getRestaurant().getName();
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
    
    
    
    

}
