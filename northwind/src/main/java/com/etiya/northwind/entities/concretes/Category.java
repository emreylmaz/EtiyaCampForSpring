package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","maintenances","products"})
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")

public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @Column(name="category_name")
    private String categoryName;
    @Column(name="description")
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
