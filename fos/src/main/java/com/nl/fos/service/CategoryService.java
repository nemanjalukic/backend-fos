package com.nl.fos.service;
import java.util.List;
import com.nl.fos.model.Category;

public interface CategoryService {

    List<Category> findAll();

    Category save(Category productCategory);

	Category findById(Long categoryType);


}
