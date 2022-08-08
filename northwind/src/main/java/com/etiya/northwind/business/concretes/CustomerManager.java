package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerListResponse> getAll() {
        List<Customer> customers =customerRepository.findAll();
        List<CustomerListResponse> responses = new ArrayList<>();

        for (Customer item: customers)
        {
            CustomerListResponse tmp = new CustomerListResponse();
            tmp.setId(item.getId());
            tmp.setCompanyName(item.getCompanyName());
            tmp.setContactName(item.getContactName());
            responses.add(tmp);
        }
        return responses;
    }
}