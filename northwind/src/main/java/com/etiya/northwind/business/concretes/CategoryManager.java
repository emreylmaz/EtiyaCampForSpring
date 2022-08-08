package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryManager implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryListResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryListResponse> responses = new ArrayList<>();

        for (Category item: categories)
        {
            CategoryListResponse categoryListResponse = new CategoryListResponse();
            categoryListResponse.setCategoryId(item.getCategoryId());
            categoryListResponse.setDescription(item.getDescription());
            categoryListResponse.setCategoryName(item.getCategoryName());

            responses.add(categoryListResponse);

        }
        return responses;
    }
}
