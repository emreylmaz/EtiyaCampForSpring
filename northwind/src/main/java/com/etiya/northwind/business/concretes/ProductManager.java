package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.request.products.CreateProductRequest;
import com.etiya.northwind.business.request.products.DeleteProductRequest;
import com.etiya.northwind.business.request.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductsListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<ProductsListResponse> getAll() {
        List<Product> result = this.productRepository.findAll();
        List<ProductsListResponse> response = result.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(result,ProductsListResponse.class) ).collect(Collectors.toList());


        return response;
    }

    @Override
    public void add(CreateProductRequest createProductRequest) {
        Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
        this.productRepository.save(product);

    }

    @Override
    public void update(UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        this.productRepository.save(product);

    }

    @Override
    public void delete(DeleteProductRequest deleteProductRequest) {
        Product product = this.modelMapperService.forRequest().map(deleteProductRequest,Product.class);
        this.productRepository.delete(product);

    }


}
