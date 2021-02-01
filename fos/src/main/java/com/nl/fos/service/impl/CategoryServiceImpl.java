package com.nl.fos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nl.fos.model.Category;
import com.nl.fos.repository.CategoryRepository;
import com.nl.fos.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;



    @Override
    public List<Category> findAll() {
        List<Category> res = categoryRepository.findAll();
        return res;
    }

	@Override
    public Category findById(Long categoryType) {
        Category res = categoryRepository.findById(categoryType).get();
        return res;
    }

    @Override
    @Transactional
    public Category save(Category productCategory) {
        return categoryRepository.save(productCategory);
    }



}
