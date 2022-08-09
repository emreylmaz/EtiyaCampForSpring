package com.etiya.northwind.api.controllers;


import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.request.products.CreateProductRequest;
import com.etiya.northwind.business.request.products.DeleteProductRequest;
import com.etiya.northwind.business.request.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ListProductsResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;
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
    public List<ListProductsResponse> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProductRequest productAddRequest){
        productService.add(productAddRequest);

    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateProductRequest updateProductRequest){

        productService.update(updateProductRequest);

    }

    @DeleteMapping("/delete")
    public void delete(DeleteProductRequest deleteProductRequest){
        productService.delete(deleteProductRequest);

    }

    @GetMapping("/getbyid")
    public ReadProductResponse findById(@RequestParam int id) {
        return this.productService.findById(id);
    }


}
