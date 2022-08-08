package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/getall")
    public List<SupplierListResponse> getAll(){
        return supplierService.getAll();
    }

}
