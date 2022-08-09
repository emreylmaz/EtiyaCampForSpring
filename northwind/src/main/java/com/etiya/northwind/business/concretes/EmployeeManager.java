package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManager implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public List<ListEmployeeResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<ListEmployeeResponse> result = employees.stream()
                .map(item -> this.modelMapperService.forResponse()
                        .map(item, ListEmployeeResponse.class)).collect(Collectors.toList());

        return result;
    }
}
