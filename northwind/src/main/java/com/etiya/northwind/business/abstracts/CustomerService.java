package com.etiya.northwind.business.abstracts;


import com.etiya.northwind.business.request.customer.CreateCustomerRequest;
import com.etiya.northwind.business.request.customer.DeleteCustomerRequest;
import com.etiya.northwind.business.request.customer.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.business.responses.customers.ReadCustomersResponse;

import java.util.List;

public interface CustomerService {
    List<ListCustomerResponse> getAll();
    void add(CreateCustomerRequest createCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest);
    void delete(DeleteCustomerRequest deleteCustomerRequest);
    ReadCustomersResponse findById(String  id);

}
