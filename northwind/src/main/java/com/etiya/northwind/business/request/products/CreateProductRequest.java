package com.etiya.northwind.business.request.products;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private int productId;
    private String productName;
    private double unitPrice;
    private int unitsInStock;
    private int supplierId ;
    private int  categoryId;
}
