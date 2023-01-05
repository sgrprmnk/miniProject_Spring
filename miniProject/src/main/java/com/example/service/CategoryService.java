package com.example.service;

import com.example.exceptions.CategoryException;
import com.example.model.Category;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category category) throws CategoryException;
    public List<Category> viewCategory(String categoryName) throws CategoryException;


}
