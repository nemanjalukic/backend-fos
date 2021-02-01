package com.nl.fos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nl.fos.model.Category;
import com.nl.fos.model.FoodItem;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
