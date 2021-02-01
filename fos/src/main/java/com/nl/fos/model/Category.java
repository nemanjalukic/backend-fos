package com.nl.fos.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = -3093364772443157782L;


	@Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    private String category;
    
    @JsonIgnore 
    @OneToMany(mappedBy = "category",targetEntity = FoodItem.class,fetch =FetchType.EAGER )
    private List<FoodItem> categoryFoodItems;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

	public List<FoodItem> getCategoryFoodItems() {
		return categoryFoodItems;
	}

	public void setCategoryFoodItems(List<FoodItem> categoryFoodItems) {
		this.categoryFoodItems = categoryFoodItems;
	}
    
    


    
    

}
