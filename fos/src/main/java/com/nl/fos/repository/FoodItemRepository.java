package com.nl.fos.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nl.fos.model.Category;
import com.nl.fos.model.FoodItem;


@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    
	Page<FoodItem> findAllByCategory(Category cat, Pageable pageable);
    Page<FoodItem> findAllByOrderById(Pageable pageable);
    Page<FoodItem> findAllByCategoryId(Long cat, Pageable pageable);
	List<FoodItem> findAllByRestaurantUsername(String name);

}
