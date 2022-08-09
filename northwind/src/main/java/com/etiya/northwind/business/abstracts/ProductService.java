package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.request.products.CreateProductRequest;
import com.etiya.northwind.business.request.products.DeleteProductRequest;
import com.etiya.northwind.business.request.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ListProductsResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;
import com.etiya.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<ListProductsResponse> getAll();
    void add(CreateProductRequest createProductRequest);
    void update(UpdateProductRequest productUpdateRequest);
    void delete(DeleteProductRequest deleteProductRequest);
    ReadProductResponse findById(int id);
}
