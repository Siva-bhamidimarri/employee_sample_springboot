package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeRowMapper;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;

@Service
public class EmployeeH2Service implements EmployeeRepository {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Employee> getEmployees() {
        List<Employee> list = db.query("select * from employee", new EmployeeRowMapper());
        return new ArrayList<>(list);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        try {
            return db.queryForObject("select * from employee where email = ?", new EmployeeRowMapper(), email);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }

    @Override
    public ArrayList<Employee> getEmployeeByName(String name) {
        List<Employee> list = db.query("select * from employee where name = ?", new EmployeeRowMapper(), name);
        return new ArrayList<>(list);
    }

    @Override
    public Employee addEmployee(Employee emp) {
        if (emp.getName() == null || emp.getEmail() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name and Email are required");

        db.update("insert into employee(name, lastName, email, phone, address) values(?, ?, ?, ?, ?)",
                emp.getName(), emp.getLastName(), emp.getEmail(), emp.getPhone(), emp.getAddress());
        return getEmployeeByEmail(emp.getEmail());
    }

    @Override
    public Employee updateEmployee(String email, Employee emp) {
        if (emp.getLastName() != null)
            db.update("update employee set lastName=? where email=?", emp.getLastName(), email);
        if (emp.getPhone() != null)
            db.update("update employee set phone=? where email=?", emp.getPhone(), email);
        if (emp.getAddress() != null)
            db.update("update employee set address=? where email=?", emp.getAddress(), email);

        return getEmployeeByEmail(email);
    }

    @Override
    public Employee updateEmployeePhone(String email, String phone) {
        db.update("update employee set phone=? where email=?", phone, email);
        return getEmployeeByEmail(email);
    }

    @Override
    public void deleteEmployee(String email) {
        db.update("delete from employee where email=?", email);
    }
}
