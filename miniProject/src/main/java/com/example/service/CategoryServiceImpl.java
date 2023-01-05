package com.example.service;

import com.example.exceptions.CategoryException;
import com.example.model.Category;
import com.example.repository.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category addCategory(Category category) throws CategoryException {
        return categoryDao.save(category);
    }

    @Override
    public List<Category> viewCategory(String categoryName) throws CategoryException {
        List<Category> categoryList = categoryDao.findByCategoryName(categoryName);
        if (categoryList.size() != 0) {
            return categoryList;
        }
        throw new CategoryException("No data found with given category name");
    }
}
