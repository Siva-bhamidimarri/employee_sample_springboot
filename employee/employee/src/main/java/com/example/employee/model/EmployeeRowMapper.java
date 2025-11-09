package com.example.employee.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("lastName"),
            rs.getString("email"),
            rs.getString("phone"),
            rs.getString("address")
        );
    }
}
