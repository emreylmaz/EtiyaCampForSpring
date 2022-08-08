package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_name")
    private String contactName;


    @OneToMany(mappedBy = "customers")
    private List<Order> orders;
}
