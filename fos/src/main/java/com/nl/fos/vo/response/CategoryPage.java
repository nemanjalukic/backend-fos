package com.nl.fos.vo.response;

import org.springframework.data.domain.Page;

import com.nl.fos.model.FoodItem;


public class CategoryPage {
    private String category;
    private Page<FoodItem> page;

    public CategoryPage(String category, Page<FoodItem> page) {
        this.category = category;
        this.page = page;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Page<FoodItem> getPage() {
        return page;
    }

    public void setPage(Page<FoodItem> page) {
        this.page = page;
    }
}
