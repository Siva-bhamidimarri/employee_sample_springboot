package com.example.employee.repository;

import com.example.employee.model.Employee;
import java.util.*;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();
    Employee getEmployeeByEmail(String email);
    ArrayList<Employee> getEmployeeByName(String name);
    Employee addEmployee(Employee emp);
    Employee updateEmployee(String email, Employee emp);
    Employee updateEmployeePhone(String email, String phone);
    void deleteEmployee(String email);
}
