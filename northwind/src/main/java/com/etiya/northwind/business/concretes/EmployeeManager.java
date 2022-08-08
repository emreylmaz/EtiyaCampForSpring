package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeManager implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeListResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeListResponse> result = new ArrayList<>();
        for (Employee item:employees)
        {
            EmployeeListResponse employeeListResponse = new EmployeeListResponse();
            employeeListResponse.setEmployeeId(item.getEmployeeId());
            employeeListResponse.setFirstName(item.getFirstName());
            employeeListResponse.setLastName(item.getLastName());
            result.add(employeeListResponse);
        }
        return result;
    }
}
