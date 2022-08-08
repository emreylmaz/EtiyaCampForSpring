package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","maintenances","products"})
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customers;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employees;

    @Column(name = "ship_name")
    private String shipName;





}
