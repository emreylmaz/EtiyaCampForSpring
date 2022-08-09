package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.request.products.CreateProductRequest;
import com.etiya.northwind.business.request.products.DeleteProductRequest;
import com.etiya.northwind.business.request.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductsListResponse;

import java.util.List;

public interface ProductService {
    List<ProductsListResponse> getAll();
    void add(CreateProductRequest createProductRequest);
    void update(UpdateProductRequest productUpdateRequest);
    void delete(DeleteProductRequest deleteProductRequest);
}
