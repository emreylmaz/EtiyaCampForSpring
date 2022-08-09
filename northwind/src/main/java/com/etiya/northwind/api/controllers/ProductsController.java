package com.etiya.northwind.api.controllers;


import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.request.products.CreateProductRequest;
import com.etiya.northwind.business.request.products.DeleteProductRequest;
import com.etiya.northwind.business.request.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductsListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<ProductsListResponse> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateProductRequest productAddRequest){
        productService.add(productAddRequest);

    }

    @PostMapping("/update")
    public void update(UpdateProductRequest updateProductRequest){
        productService.update(updateProductRequest);

    }

    @DeleteMapping("delete/{customerId}")
    public void delete(DeleteProductRequest deleteProductRequest){
        productService.delete(deleteProductRequest);

    }


}
