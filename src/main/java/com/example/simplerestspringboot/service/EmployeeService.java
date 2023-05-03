package com.example.simplerestspringboot.service;

import com.example.simplerestspringboot.data.models.Employee;
import com.example.simplerestspringboot.data.payloads.EmployeeRequest;
import com.example.simplerestspringboot.data.payloads.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {
    MessageResponse createEmployee(EmployeeRequest employeeRequest);

    List<Employee> all();

    Employee getById(Integer id);

    void delete(Integer id);

    void update(Integer id, EmployeeRequest employeeRequest);
}
