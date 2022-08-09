package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierManager implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ModelMapperService modelMapperService;


    @Override
    public List<SupplierListResponse> getAll() {
        List<Supplier> result = supplierRepository.findAll();
        List<SupplierListResponse> response = result.stream()
                .map(item -> this.modelMapperService.forResponse()
                        .map(item,SupplierListResponse.class)).collect(Collectors.toList());


        return response;
    }
}
