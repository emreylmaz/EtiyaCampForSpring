package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.responses.products.ProductsListResponse;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductsListResponse> getAll() {
        List<Product> result = this.productRepository.findAll();
        List<ProductsListResponse> response = new ArrayList<ProductsListResponse>();

        for (Product product : result){
            ProductsListResponse responseProduct = new ProductsListResponse();
            responseProduct.setCategoryId(product.getCategory().getCategoryId());
            responseProduct.setCategoryName(product.getCategory().getCategoryName());
            responseProduct.setProductId(product.getProductId());
            responseProduct.setProductName(product.getProductName());
            responseProduct.setUnitPrice(product.getUnitPrice());
            responseProduct.setUnitInStock(product.getUnitsInStock());

            response.add(responseProduct);
        }
        return response;
    }
}
