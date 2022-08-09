package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<CustomerListResponse> getAll() {
        List<Customer> customers =customerRepository.findAll();
        List<CustomerListResponse> responses = customers.stream().map(item -> this.modelMapperService.forResponse()
                .map(item, CustomerListResponse.class)).collect(Collectors.toList());

        return responses;
    }
}