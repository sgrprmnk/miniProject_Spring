package com.example.controller;

import com.example.exceptions.CategoryException;
import com.example.model.Category;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/category")
    public ResponseEntity<Category>  addCategoryHandler(@RequestBody Category category) throws CategoryException {
        Category category1=categoryService.addCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }
    @GetMapping("/category/{catName}")
    public ResponseEntity<List<Category>> viewCategoryHandler(@PathVariable("catName") String catName) throws CategoryException {
        List<Category> categoryList=categoryService.viewCategory(catName);
        return new ResponseEntity<>(categoryList,HttpStatus.FOUND);
    }

}
