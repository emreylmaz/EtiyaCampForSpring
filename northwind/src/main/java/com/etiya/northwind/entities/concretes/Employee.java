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
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @OneToMany(mappedBy = "employees")
    private List<Order> orders;
}
