package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.request.customer.CreateCustomerRequest;
import com.etiya.northwind.business.request.customer.DeleteCustomerRequest;
import com.etiya.northwind.business.request.customer.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.business.responses.customers.ReadCustomersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getall")
    public List<ListCustomerResponse> getAll()
    {
        return  customerService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCustomerRequest createCustomerRequest){
        customerService.add(createCustomerRequest);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        customerService.update(updateCustomerRequest);

    }

    @DeleteMapping("/delete")
    public void delete(DeleteCustomerRequest deleteCustomerRequest){
        customerService.delete(deleteCustomerRequest);
    }

    @PostMapping("getbyid")
    public ReadCustomersResponse findById(String id){
        return this.customerService.findById(id);
    }
}
