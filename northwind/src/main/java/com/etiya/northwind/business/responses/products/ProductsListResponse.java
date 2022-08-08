package com.etiya.northwind.business.responses.products;

import com.etiya.northwind.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsListResponse {


    private int productId;


    private String productName;


    private double unitPrice;


    private int unitInStock;

    private int categoryId;

    private String categoryName;
}
