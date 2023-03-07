package com.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperEmployeeImpl implements RowMapper<Employee>{ 

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee=new Employee();
		
		employee.setEmployee_id(rs.getInt(1));
		employee.setEmployee_name(rs.getString(2));
		employee.setEmployee_city(rs.getString(3));
		employee.setEmployee_salary(rs.getInt(4));
		
		return employee;
	}
	
	
	
	

}
