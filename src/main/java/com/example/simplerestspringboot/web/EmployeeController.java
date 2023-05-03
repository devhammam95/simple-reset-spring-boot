package com.example.simplerestspringboot.web;

import com.example.simplerestspringboot.data.models.Employee;
import com.example.simplerestspringboot.data.payloads.EmployeeRequest;
import com.example.simplerestspringboot.data.payloads.MessageResponse;
import com.example.simplerestspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private Environment environment;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name)
    {
        return String.format("Hello  %s", environment.getProperty("spring.application.name"));
    }


    @PostMapping("/")
    public ResponseEntity<MessageResponse> create(@Valid @RequestBody EmployeeRequest employeeRequest)
    {
        MessageResponse employee = employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> all()
    {
        List<Employee> employees = employeeService.all();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id)
    {
        Employee employee = employeeService.getById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id)
    {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody EmployeeRequest employeeRequest, @PathVariable Integer id)
    {
        employeeService.update(id, employeeRequest);
        return ResponseEntity.ok().build();
    }
}
