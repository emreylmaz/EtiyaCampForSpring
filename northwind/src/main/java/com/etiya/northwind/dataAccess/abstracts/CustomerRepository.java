package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
