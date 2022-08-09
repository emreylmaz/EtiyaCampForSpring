package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.responses.products.ProductsListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
