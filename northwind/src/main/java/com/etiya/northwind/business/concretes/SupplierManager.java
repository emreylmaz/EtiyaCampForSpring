package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierManager implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;


    @Override
    public List<SupplierListResponse> getAll() {
        List<Supplier> result = supplierRepository.findAll();
        List<SupplierListResponse> response = new ArrayList<>();

        for (Supplier supplier : result){
            SupplierListResponse supplierListResponse = new SupplierListResponse();
            supplierListResponse.setSupplierId(supplier.getSupplierId());
            supplierListResponse.setContactName(supplier.getContactName());
            supplierListResponse.setCompanyName(supplier.getCompanyName());

            response.add(supplierListResponse);
        }

        return response;
    }
}
