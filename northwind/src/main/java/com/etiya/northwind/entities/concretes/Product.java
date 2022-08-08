package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="unit_price")
    private double unitPrice;
    @Column(name="units_in_stock")
    private int unitsInStock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}