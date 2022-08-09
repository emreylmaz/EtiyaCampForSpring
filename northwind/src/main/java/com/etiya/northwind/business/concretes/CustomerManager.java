package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.request.customer.CreateCustomerRequest;
import com.etiya.northwind.business.request.customer.DeleteCustomerRequest;
import com.etiya.northwind.business.request.customer.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.business.responses.customers.ReadCustomersResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public List<ListCustomerResponse> getAll() {
        List<Customer> customers =customerRepository.findAll();
        List<ListCustomerResponse> responses = customers.stream().map(item -> this.modelMapperService.forResponse()
                .map(item, ListCustomerResponse.class)).collect(Collectors.toList());

        return responses;
    }

    @Override
    public void add(CreateCustomerRequest createCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        this.customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        this.customerRepository.save(customer);

    }

    @Override
    public void delete(DeleteCustomerRequest deleteCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(deleteCustomerRequest, Customer.class);
        this.customerRepository.delete(customer);
    }

    @Override
    public ReadCustomersResponse findById(String id) {
        Customer customer = this.customerRepository.findById(Integer.valueOf(id)).get();
        ReadCustomersResponse response = this.modelMapperService.forResponse().map(customer, ReadCustomersResponse.class);
        return response;
    }


}