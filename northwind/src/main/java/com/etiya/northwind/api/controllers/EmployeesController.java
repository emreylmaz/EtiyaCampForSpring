package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getall")
    public List<EmployeeListResponse> getAll() {
        return employeeService.getAll();
    }


}
