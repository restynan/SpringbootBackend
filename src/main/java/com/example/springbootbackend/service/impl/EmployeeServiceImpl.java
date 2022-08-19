package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.model.Employee;
import com.example.springbootbackend.model.ResourceNotFoundException;
import com.example.springbootbackend.repository.EmployeeRepository;
import com.example.springbootbackend.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
         return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {

        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id",id));

    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee employee1 = getEmployee(employeeId);
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        return employeeRepository.save(employee1);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee","id",employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
