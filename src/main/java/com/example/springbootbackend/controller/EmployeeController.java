package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Employee;
import com.example.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    // build save Employee API
    @PostMapping
    public ResponseEntity<Employee>saveEmployee(@RequestBody  Employee employee){
        return  new ResponseEntity<>( employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    
    // build get  All Employee API
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return  new ResponseEntity<>( employeeService.getAllEmployees(),HttpStatus.OK);
    }

   //build  find employee by ID
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId){
            return new ResponseEntity<>( employeeService.getEmployee(employeeId),HttpStatus.OK);
    }

    // build update employee
    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employeeId,employee),HttpStatus.OK);

    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

    
    
}
