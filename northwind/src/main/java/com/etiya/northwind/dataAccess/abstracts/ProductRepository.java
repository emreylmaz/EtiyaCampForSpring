package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer> {
}
