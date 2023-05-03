package com.example.simplerestspringboot.data.payloads;

import com.example.simplerestspringboot.data.models.Department;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeRequest {

    @NotBlank
    @NotNull(message = "FirstName not null")
    private String firstName;

    @NotBlank
    @NotNull(message = "lastName not null")
    private String lastName;

    @NotBlank
    @NotNull
    @NumberFormat
    private String phoneNumber;

    @NotBlank
    @NotNull
    @Email
    private String email;

    @DecimalMin(value = "1.0", message = "Please Enter a valid Amount")
    private double salary;

    private Department department;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
