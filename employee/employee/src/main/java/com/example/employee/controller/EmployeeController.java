package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeH2Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeH2Service employeeService;

    @GetMapping
    public ArrayList<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/email/{email}")
    public Employee getByEmail(@PathVariable String email) {
        return employeeService.getEmployeeByEmail(email);
    }

    @GetMapping("/name/{name}")
    public ArrayList<Employee> getByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        return employeeService.addEmployee(emp);
    }

    @PutMapping("/{email}")
    public Employee updateEmployee(@PathVariable String email, @RequestBody Employee emp) {
        return employeeService.updateEmployee(email, emp);
    }

    @PatchMapping("/{email}/phone")
    public Employee updatePhone(@PathVariable String email, @RequestBody String phone) {
        return employeeService.updateEmployeePhone(email, phone);
    }

    @DeleteMapping("/{email}")
    public void deleteEmployee(@PathVariable String email) {
        employeeService.deleteEmployee(email);
    }
}
