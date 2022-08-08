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
@Table(name = "suppliers")
public class Supplier {
    @Id
    @Column(name="supplier_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;

    @Column(name= "company_name")
    private String  companyName;

    @Column(name= "contact_name")
    private String  contactName;
}
