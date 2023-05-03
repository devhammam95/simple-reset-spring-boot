package com.example.simplerestspringboot.service;

import com.example.simplerestspringboot.data.models.Employee;
import com.example.simplerestspringboot.data.payloads.EmployeeRequest;
import com.example.simplerestspringboot.data.payloads.MessageResponse;
import com.example.simplerestspringboot.data.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    public MessageResponse createEmployee(EmployeeRequest employeeRequest)
    {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employeeRequest.getFirstName());
        newEmployee.setLastname(employeeRequest.getLastName());
        newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        newEmployee.setEmail(employeeRequest.getEmail());
        newEmployee.setSalary(employeeRequest.getSalary());
        newEmployee.setDepartment(employeeRequest.getDepartment());
        employeeRepository.save(newEmployee);
        return new MessageResponse("New Employee created successfully");
    }

    public List<Employee> all()
    {
        return employeeRepository.findAll();
    }

    public Employee getById(Integer id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        }
        throw new EntityNotFoundException("Employee isn't existed");
    }

    public void delete(Integer id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EntityNotFoundException("Employee id not existed");
        }
        employeeRepository.deleteById(id);
    }

    public void update(Integer id, EmployeeRequest employeeRequest)
    {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent()) {
            throw new EntityNotFoundException("Entity not found");
        }

        Employee employee = optionalEmployee.get();

        BeanUtils.copyProperties(employeeRequest, employee);
        employeeRepository.save(employee);
    }
}
