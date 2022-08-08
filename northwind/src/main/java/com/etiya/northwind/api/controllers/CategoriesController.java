package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getall")
    public List<CategoryListResponse> getAll(){
        return categoryService.getAll();
    }
}
