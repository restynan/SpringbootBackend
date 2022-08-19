package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployee(Long id);
    Employee updateEmployee(Long employeeId, Employee employee);

    void deleteEmployee(Long employeeId);
}
