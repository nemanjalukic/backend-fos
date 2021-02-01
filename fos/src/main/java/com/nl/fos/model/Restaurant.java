package com.nl.fos.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nl.fos.vo.request.SignUpRequest;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
public class Restaurant extends User implements Serializable{

	private static final long serialVersionUID = 845182104842681367L;

	@Column(nullable = false, length = 45)
    private String name;
	
    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", targetEntity = Order.class, fetch = FetchType.EAGER)
    private List<Order> restaurantOrders;
    
    @JsonIgnore 
    @OneToMany(mappedBy = "restaurant", targetEntity = FoodItem.class,fetch =FetchType.EAGER)
    private Set<FoodItem> restaurantFoodItems;

    public Restaurant() {}
    
    public Restaurant(SignUpRequest signUpRequest) {
		super(signUpRequest);
		this.name=signUpRequest.getRestaurantName();
		
	}
    
    public String getName() {
        return name;
    }

	public void setName(final String name) {
        this.name = name;
    }

	public List<Order> getRestaurantOrders() {
		return restaurantOrders;
	}

	public void setRestaurantOrders(List<Order> restaurantOrders) {
		this.restaurantOrders = restaurantOrders;
	}

	public Set<FoodItem> getRestaurantFoodItems() {
		return restaurantFoodItems;
	}

	public void setRestaurantFoodItems(Set<FoodItem> restaurantFoodItems) {
		this.restaurantFoodItems = restaurantFoodItems;
	}
	
	

}
