package com.etiya.northwind.business.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProductsResponse {


    private int productId;


    private String productName;


    private double unitPrice;


    private int unitInStock;

    private int categoryId;

    private String categoryName;

    private int supplierId;
}
